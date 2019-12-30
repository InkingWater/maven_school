package xyz.lightseekers.maven_school.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.lightseekers.maven_school.service.IQuestionService;
import xyz.lightseekers.maven_school.util.Message;
import xyz.lightseekers.maven_school.util.MessageUtil;

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
    /**
     * 尝试更新
     */
    @Autowired
    private IQuestionService questionService;

    @GetMapping("/selectById")
    @ApiOperation(value = "根据编号选择问题")
    public Message selectById(int id) {
        return MessageUtil.success(questionService.selectById(id));
    }
}
