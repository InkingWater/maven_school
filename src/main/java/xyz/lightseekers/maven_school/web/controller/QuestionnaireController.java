package xyz.lightseekers.maven_school.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lightseekers.maven_school.service.IQuestionnaireService;
import xyz.lightseekers.maven_school.util.Message;
import xyz.lightseekers.maven_school.util.MessageUtil;

@RestController
@Api(description = "问卷管理")
@RequestMapping("/questionnaire")
public class QuestionnaireController {

    @Autowired
    private IQuestionnaireService questionnaireService;


    @ApiOperation("查询所有问卷")
    @GetMapping("/findAll")
    public Message findAll(){
        return MessageUtil.success(questionnaireService.findAll());
    }

    @ApiOperation("条件搜索")
    @GetMapping("/search")
    public Message search(String word){
        return MessageUtil.success(questionnaireService.search(word));
    }

    @ApiOperation(("根据Id删除"))
    @GetMapping("/del")
    public Message del(int id)
    {
       // questionnaireService.deleteS(id);
        questionnaireService.deleteByid(id);
        return MessageUtil.success();
    }

    @ApiOperation("批量删除")
    @GetMapping("/deleteM")
    public Message deleteM(int id[])
    {
        questionnaireService.deleteM(id);
        return MessageUtil.success();
    }



}
