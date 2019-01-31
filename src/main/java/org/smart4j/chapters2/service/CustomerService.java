package org.smart4j.chapters2.service;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.slf4j.LoggerFactory;
import org.smart4j.chapters2.common.PropUtils;
import org.smart4j.chapters2.helper.DataBaseHelper;
import org.smart4j.chapters2.model.Customer;

import javax.jws.WebService;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 提供客户数据服务
 */
public class CustomerService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    /**
     * 获取客户列表
     *
     */
    public List<Customer> getCustomerList() {
        /*Connection conn = null;*/
        Connection conn = DataBaseHelper.getConnction();

        try {
            List<Customer> customers = new ArrayList<Customer>();
            String sql = "select * from customer";
            /*conn = DataBaseHelper.getConnction();*/
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getLong("id"));
                customer.setName(resultSet.getString("name"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setContact(resultSet.getString("contact"));
                customer.setEmail(resultSet.getString("email"));
                customer.setRemark(resultSet.getString("remark"));
                customers.add(customer);
            }
            return customers;

            /*return DataBaseHelper.queryEntityList(Customer.class,sql);*/

        } catch (SQLException e) {
            LOGGER.error("execute sql failure");
        } finally {

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 根据客户id获取客户信息
     */
    public Customer getCustomerInfo(long id){
        String sql ="select * from customer where id=?";
        return DataBaseHelper.queryEntity(Customer.class,sql,id);
    };
    /**
     * 创建客户
     */
    public boolean createCustomer(Map<String,Object> fieldMap){
        return DataBaseHelper.insertEntity(Customer.class,fieldMap);
    }
    /**
     * 更新客户信息
     */
    public boolean updateCustomer(long id, Map<String, Object> fieldMap){
        return DataBaseHelper.updateEntity(Customer.class,id,fieldMap);
    }
    /**
     * 删除客户
     * @param id
     *
     */
    public boolean deleteCustomer(Class<?> entityClass, long id){
        return DataBaseHelper.deleteEntity(Customer.class,id);
    }
}
