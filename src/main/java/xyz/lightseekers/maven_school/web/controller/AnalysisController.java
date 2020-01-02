package xyz.lightseekers.maven_school.web.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lightseekers.maven_school.bean.ex.ClazzEXQ;
import xyz.lightseekers.maven_school.service.ISurveyAnalysisOfClazzService;
import xyz.lightseekers.maven_school.util.Message;
import xyz.lightseekers.maven_school.util.MessageUtil;

import java.util.List;

@RestController
@RequestMapping("AnalysisController")
@Api(description = "课调统计-班级课调分析")
public class AnalysisController {

    @Autowired
    private ISurveyAnalysisOfClazzService service;

    @GetMapping("/selectClazz")
    @ApiOperation(value = "查询全部班级")
    public Message selectClazz() {
        List<ClazzEXQ> list = service.selectClazz();
        return MessageUtil.success(list);
    }

    @GetMapping("/searchClazz")
    @ApiOperation(value = "搜索栏")
    public Message selectClazz(Integer grade, Integer clazz, String word) {
        List<ClazzEXQ> list = service.searchClazz(grade, clazz, word);
        return MessageUtil.success(list);
    }
//    @GetMapping("/Test")
//    public Message test(String s){
//        List<ClazzEXQ> list = service.test(s);
//        return MessageUtil.success(list);
//    }
}