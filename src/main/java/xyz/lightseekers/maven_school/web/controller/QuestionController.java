package xyz.lightseekers.maven_school.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.lightseekers.maven_school.bean.Question;
import xyz.lightseekers.maven_school.bean.ex.OptionsEX;
import xyz.lightseekers.maven_school.bean.ex.QuestionEX;
import xyz.lightseekers.maven_school.service.IQuestionService;
import xyz.lightseekers.maven_school.util.Message;
import xyz.lightseekers.maven_school.util.MessageUtil;

import java.util.List;

/**
 * @Author: ZhiliangJia
 * @Description:
 * @Date:Create in 20:45 2019/12/29
 * @Modified User:
 */
@RestController
@RequestMapping(value = "question")
@Api(description = "题目管理")
public class QuestionController {

    @Autowired
    private IQuestionService questionService;



    @GetMapping("/selectById")
    @ApiOperation(value = "根据编号选择问题")
    public Message selectById(int id) {
        return MessageUtil.success(questionService.selectById(id));
    }


    @PostMapping("/add")
    @ApiOperation(value = "添加问题")
    public Message add(QuestionEX questionEX, @RequestBody List<OptionsEX> optionsEXES){
        questionService.insertOrUpdateQuestion(questionEX);
        for (OptionsEX optionsEX : optionsEXES) {

            optionsEX.setQuestionEX(questionEX);
            questionService.insertOptions(optionsEX);
        }
        return MessageUtil.success();
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改问题信息")
    public Message update(QuestionEX questionEX){
        return MessageUtil.success(questionService.insertOrUpdateQuestion(questionEX));
    }


    @GetMapping("/findAll")
    @ApiOperation(value = "寻找所有")
    public Message findAll(){
        List<QuestionEX> questionEXES = questionService.findAll();
        return MessageUtil.success();
    }


    @GetMapping("/selectByName")
    @ApiOperation(value = "按条件查找（name）")
    public Message selectByName(String con){
        List<QuestionEX> list = questionService.selectByCon(con);
        return MessageUtil.success(list);
    }

}
