package xyz.lightseekers.maven_school.web.controller;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Description:
 * @Author: Light
 * @Date: 2020/1/3 9:12
 */
//@RestController
//@RequestMapping(value = "jzl")
public class JzlController {

//    @GetMapping("/download")
    public void download(HttpServletResponse response) throws Exception {
        this.salaryTemplate(response);
    }

    private void salaryTemplate(HttpServletResponse response) throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook();
        exportExcel(workbook);
        response.setHeader("Content-type", "application/vnd.ms-excel");
        // 解决导出文件名中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode("table"+".xlsx", "utf-8"));
        workbook.write(response.getOutputStream());
    }

    //导入为模版
    private void exportExcel(HSSFWorkbook workbook) throws Exception {
    //创建创建sheet
        HSSFSheet sheet = workbook.createSheet("工资");
        //创建单元格样式
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        //设置首行标题标题
        HSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellStyle(cellStyle);
        headerRow.createCell(0).setCellValue("工号");
        headerRow.createCell(1).setCellStyle(cellStyle);
        headerRow.createCell(1).setCellValue("姓名");
        headerRow.createCell(2).setCellStyle(cellStyle);
        headerRow.createCell(2).setCellValue("年龄");
        //创建三行数据
        HSSFRow row;
        for (int i = 0; i < 4; i++) {
            row = sheet.createRow(i + 1);
            row.createCell(0).setCellStyle(cellStyle);
            row.createCell(0).setCellValue(i);
            row.createCell(1).setCellStyle(cellStyle);
            row.createCell(1).setCellValue("张三");
            row.createCell(2).setCellStyle(cellStyle);
            row.createCell(2).setCellValue(19);
        }
    }
}
