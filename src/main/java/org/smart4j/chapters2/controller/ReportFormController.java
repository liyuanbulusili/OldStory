/*
package org.smart4j.chapters2.controller;

import com.ymkj.base.core.web.controller.BaseController;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.util.ExcelUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.PageData;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping(value = "/report")
public class ReportFormController extends BaseController {
    @Resource(name = "reportService")
    private ReportManager reportService;
    */
/**
     * 导出报表
     *
     *//*

    public void export(HttpServletRequest request,HttpServletResponse response) throws Exception{
        //获取数据
        List<PageData> list = reportService.bookList(page);

        //excel标题
        String[] title = {"名称","性别","年龄","学校","班级"};
        //excel文件名
        String fileName = "学生信息表"+System.currentTimeMillis()+".xls";
        //excel 内容
        String[] content[] = null;
        //sheet名
        String sheetName = "学生信息表";
        for(int i=0;i<list.size();i++){
            content[i] = new String[title.length];
            PageData obj = list.get(i);
            content[i][0] = obj.get("stuName").tostring();
            content[i][1] = obj.get("stuSex").tostring();
            content[i][2] = obj.get("stuAge").tostring();
            content[i][3] = obj.get("stuSchoolName").tostring();
            content[i][4] = obj.get("stuClassName").tostring();
        }

//创建HSSFWorkbook
HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

//响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
*/
