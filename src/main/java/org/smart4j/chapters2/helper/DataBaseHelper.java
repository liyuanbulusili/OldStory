package org.smart4j.chapters2.helper;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.managed.BasicManagedDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.log4j.Logger;
import org.smart4j.chapters2.common.CollectionUtil;
import org.smart4j.chapters2.common.PropUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class DataBaseHelper {
    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;
    private static final Logger LOGGER = Logger.getLogger(DataBaseHelper.class);
    private static final ThreadLocal<Connection> CONNECTION_HODLER;
    private static final QueryRunner QUERY_RUNNER;
    private static final BasicDataSource DATA_SOURCE;

    static{
        CONNECTION_HODLER = new ThreadLocal<Connection>();
        QUERY_RUNNER= new QueryRunner();
        Properties props = PropUtils.loadProps("config.properties");
        DRIVER = props.getProperty("jdbc.driver");
        URL = props.getProperty("jdbc.url");
        USERNAME = props.getProperty("jdbc.username");
        PASSWORD = props.getProperty("jdbc.password");
        DATA_SOURCE  = new BasicDataSource();
        DATA_SOURCE.setDriverClassName(DRIVER);
        DATA_SOURCE.setUrl(URL);
        DATA_SOURCE.setUsername(USERNAME);
        DATA_SOURCE.setPassword(PASSWORD);
        DATA_SOURCE.setInitialSize(10);
    }
    /**
     * 获取数据库连接
     *
     */
    public static Connection getConnction(){
        Connection conn=CONNECTION_HODLER.get();
        if(conn==null){
            try {
                conn = DATA_SOURCE.getConnection();
            } catch (SQLException e) {
                LOGGER.error("get connection failure");
                throw new RuntimeException(e);
            } finally {
                CONNECTION_HODLER.set(conn);
            }

        }
        return conn;
    }
    /**
     *关闭数据库连接
      */
    public static void closeConnection(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                LOGGER.error("close connection failure...");
            }
        }

    }
    /**
     * 查询实体列表
     */
    public static <T> List<T> queryEntityList(Class<T> entityClass, String sql, Object... params){
        List<T> entityList;
        try {
            Connection conn = getConnction();
            entityList = QUERY_RUNNER.query(conn, sql, new BeanListHandler<>(entityClass), params);
        } catch (SQLException e) {
            LOGGER.error("query entity list failure");
            throw new RuntimeException(e);
        }finally{
            closeConnection(getConnction());
        }
        return entityList;
    }
    /**
     * 查询单个实体
     */
    public static<T> T queryEntity(Class<T> entityClass,String sql,Object... params){
        T entity;
        Connection conn = getConnction();
        try {
            entity = QUERY_RUNNER.query(conn, sql, new BeanHandler<T>(entityClass), params);
        } catch (SQLException e) {
            LOGGER.error("query entity failure");
            throw new RuntimeException(e);
        }finally {
            closeConnection(conn);
        }

        return entity;
    }
    /**
     * 执行查询语句
     */
    public static List<Map<String,Object>> executeQuery(String sql,Object... params){
        List<Map<String,Object>> result;
        Connection conn = getConnction();
        try {
            result= QUERY_RUNNER.query(conn, sql, new MapListHandler(), params);
        } catch (SQLException e) {
            LOGGER.error("query sql failure");
            throw new RuntimeException(e);
        } finally {
            closeConnection(conn);
        }return result;
    }
    /**
     * 执行更新语句
     */
    public static int executeUpdate(String sql,Object... params){
        List<Map<String,Object>> result;
        int rows=0;
        try {
            Connection conn = getConnction();
            rows = QUERY_RUNNER.update(conn, sql, params);
        } catch (SQLException e) {
            LOGGER.error("update sql failure");
            throw new RuntimeException(e);
        } finally {
            closeConnection(getConnction());
        }
return rows;

    }
    /**
     * 输入实体
     */
    public static <T> boolean insertEntity(Class<T> entityClass,Map<String,Object> fieldMap){
        if(CollectionUtil.isEmpty(fieldMap)){
            LOGGER.error("can not insert entity :fieldMap is empty");
            return false;
        }
        String sql = "insert into"+getTableName(entityClass);
        StringBuilder columns = new StringBuilder("(");
        StringBuilder values = new StringBuilder("(");
        for(String fieldName:fieldMap.keySet()){
            columns.append("?, ");
        }
        columns.replace(columns.lastIndexOf(", "),columns.length(),")");
        values.replace(values.lastIndexOf(", "),values.length(),")");
        sql+=columns+"VALUES"+values;
        Object[] objects = fieldMap.values().toArray();
        return executeUpdate(sql,objects)==1;


    }
    /**
     * 更新实体
     */
    public static <T> boolean updateEntity(Class<T> enrityClass,long id,Map<String,Object> fieldMap){
        if(CollectionUtil.isEmpty(fieldMap)){
            LOGGER.error("can not update entity:fieldMap is empty");
            return false;
        }
        String sql ="update "+getTableName(enrityClass)+"set";
        StringBuilder columns = new StringBuilder();
        for(String fieldName:fieldMap.keySet()){
            columns.append(fieldName).append("=?, ");
        }
        sql+=columns.substring(0,columns.lastIndexOf(", "))+"where id=?";
        ArrayList<Object> list = new ArrayList<>();
        list.addAll(fieldMap.values());
        list.add(id);
        Object[] array = list.toArray();
        return executeUpdate(sql,array)==1;

    }
/**
 * 删除实体
 */
public static <T> boolean deleteEntity(Class entityClass,long id){
    String sql ="delete from"+getTableName(entityClass)+"where id=?";
    return executeUpdate(sql,id)==1;

}
private static String getTableName(Class<?> entityClass){
    return entityClass.getSimpleName();
}


}
