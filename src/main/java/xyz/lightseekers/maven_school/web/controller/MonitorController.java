package xyz.lightseekers.maven_school.web.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lightseekers.maven_school.bean.ex.SurveyEXQ;
import xyz.lightseekers.maven_school.service.ISurveyQService;
import xyz.lightseekers.maven_school.util.DaoUtil;
import xyz.lightseekers.maven_school.util.Message;
import xyz.lightseekers.maven_school.util.MessageUtil;

import java.util.List;

@RestController
@RequestMapping("/MonitorController")
@Api(description = "课调监控")
public class MonitorController {
    @Autowired
    private ISurveyQService surveyQService;

    @GetMapping("/selectById")
    @ApiOperation(value = "查询指定课调的全部信息")
    public Message selectById(int id){
        SurveyEXQ surveyEXQ = surveyQService.selectById(id);
        return MessageUtil.success(surveyEXQ);
    }


    @PostMapping("/startOrStop")
    @ApiOperation(value = "开启或者关闭")
    @ApiImplicitParam(name = "id",value = "修改的课调ID",paramType = "query",dataType = "int",required = true)
    public Message start(int id){
        return MessageUtil.success(surveyQService.startOrStop(id));
    }

    @GetMapping("/searchByName")
    @ApiOperation(value = "搜索框")
    @ApiImplicitParam(name = "word",value = "搜索的内容",paramType = "query",dataType = "String",required = true)
    public Message searchByName(String word){
        List<SurveyEXQ> list =surveyQService.searchByName(word);
        return MessageUtil.success(list);
    }

    @GetMapping("/selectAll")
    @ApiOperation(value = "查询全部课调信息")
    public Message selectAll(){
        List<SurveyEXQ> list =surveyQService.selectAll();
        return MessageUtil.success(list);
    }

    @GetMapping("/selectAllByStatus")
    @ApiOperation(value = "查询需要修改状态的课调信息")
    public Message selectAllByStatus(){
        List<SurveyEXQ> list =surveyQService.selectAllByStatus();
        return MessageUtil.success(list);
    }
}
