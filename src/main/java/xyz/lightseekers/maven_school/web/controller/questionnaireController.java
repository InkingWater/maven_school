package xyz.lightseekers.maven_school.web.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lightseekers.maven_school.service.IQuestionnaireService;
import xyz.lightseekers.maven_school.util.Message;
import xyz.lightseekers.maven_school.util.MessageUtil;

@RestController
@RequestMapping("/questionnaire")
public class questionnaireController {

    @Autowired
    private IQuestionnaireService questionnaireService;

    @ApiOperation("查询所有问卷")
    @GetMapping("/findAll")
    public Message findAll(){
        return MessageUtil.success(questionnaireService.findAll());
    }



}
