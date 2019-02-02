package org.smart4j.framework.util;

import org.apache.poi.hssf.usermodel.*;

/**
 * Excel导出工具类
 */
public class ExcelUtil {
    /**
     * 创建HSSFBOOK实例
     */
    public static HSSFWorkbook getHSSFWorkbook(String sheetName,String title[],String [][]values,HSSFWorkbook hssfWorkbook){
        //第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if(null==hssfWorkbook){
            hssfWorkbook = new HSSFWorkbook();
        }
        //第二部，在hssfWorkbook中添加一个sheet，对应Excel文件中的sheet
        HSSFSheet sheet = hssfWorkbook.createSheet();
        //第三部，在sheet中添加表头第0行
        HSSFRow row = sheet.createRow(0);
        //第四部，创建单元格，并设置表头，设置表头居中
        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//创建一个居中式
        //声明列对象
        HSSFCell hssfCell = null;
        //创建标题
        for(int i=0;i<title.length;i++){
             hssfCell = row.createCell(i);
             hssfCell.setCellValue(title[i]);
             hssfCell.setCellStyle(cellStyle);

        }
        //创建内容
        for(int i=0;i<values.length;i++){
            sheet.createRow(i+1);
            for(int j=0;j<values[i].length;j++){
                //将内容按顺序赋给对应的列对象
                row.createCell(j).setCellValue(values[i][j]);
            }
        }
        return hssfWorkbook;


    }

}
