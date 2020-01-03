package xyz.lightseekers.maven_school.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lightseekers.maven_school.bean.Answer;
import xyz.lightseekers.maven_school.bean.ex.SurverAllEx;
import xyz.lightseekers.maven_school.service.impl.SurverAllServiceImpl;
import xyz.lightseekers.maven_school.util.Message;
import xyz.lightseekers.maven_school.util.MessageUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@RequestMapping("/surverAll")
@RestController
@Api(description = "全部课调")
public class SurverAllController {

    @Autowired
    private SurverAllServiceImpl surverAllService;

    @ApiOperation("查询所有课调")
    @GetMapping("/findAll")
    public Message findAll(){
        return MessageUtil.success(surverAllService.findAll());
    }
    @ApiOperation("根据id查询课调信息")
    @GetMapping("/findASurverById")
    public Message findASurverById(int id){
        return MessageUtil.success(surverAllService.findASurverById(id));
    }

    @ApiOperation("条件搜索")
    @GetMapping("/search")
    public Message search(String department,String clazz,String course,String questionnaire, String word){
        return MessageUtil.success(surverAllService.search(department, clazz, course, questionnaire, word));
    }
    @ApiOperation("下载")
    @GetMapping("/download")
    public void download(HttpServletResponse response,int id) throws IOException {


        SurverAllEx surverAll= surverAllService.findASurverById(id);


        XSSFWorkbook sheets = new XSSFWorkbook();
        XSSFSheet sheet = sheets.createSheet("测试");


        XSSFRow row2 = sheet.createRow(0);
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,7));
        row2.createCell(0).setCellValue("课调信息");



        XSSFRow row = sheet.createRow(1);

        row.createCell(0).setCellValue("班级:");
        row.createCell(1).setCellValue(surverAll.getClazz().getName());
        row.createCell(2).setCellValue("讲师：");
        row.createCell(3).setCellValue(surverAll.getTeacher().getName());
        row.createCell(4).setCellValue("课程:");
        row.createCell(5).setCellValue(surverAll.getCourse().getName());
        row.createCell(6).setCellValue("平均分：");
        row.createCell(7).setCellValue(surverAll.getAverage());

        List<Answer> answers = surverAll.getAnswers();
        for (int i=0;i<answers.size();i++){
            XSSFRow row1 = sheet.createRow(i + 2);
            row1.createCell(0).setCellValue(i+1);
            row1.createCell(1).setCellValue(answers.get(i).getAnswer());
            sheet.addMergedRegion(new CellRangeAddress(i + 2,i + 2,1,3));

        }




        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(surverAll.getTeacher().getName()+"课调.xlsx", "utf-8"));
        sheets.write(response.getOutputStream());

    }
}
