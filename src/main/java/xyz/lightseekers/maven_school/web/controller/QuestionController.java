package xyz.lightseekers.maven_school.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.lightseekers.maven_school.bean.Options;
import xyz.lightseekers.maven_school.bean.Question;
import xyz.lightseekers.maven_school.bean.ex.QuestionEX;
import xyz.lightseekers.maven_school.service.IOptionsService;
import xyz.lightseekers.maven_school.service.IQuestionService;
import xyz.lightseekers.maven_school.util.DaoUtil;
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

    @Autowired
    private IOptionsService optionService;

    /**
     * 根据主键选择问题
     *
     * @param id：主键
     * @return
     */
    @GetMapping("/selectById")
    @ApiOperation(value = "根据编号选择问题")
    public Message selectById(int id) {
        return MessageUtil.success(questionService.selectById(id));
    }

    /**
     * 根据主键删除问题（单表）
     */
    @GetMapping("/deleteOptionById")
    @ApiOperation(value = "根据主键删除选项")
    public Message deleteOptionById(int id) {
        questionService.deleteOptionsById(id);
        return MessageUtil.success(DaoUtil.DELETE);
    }

    /**
     * 显示全部内容（题目+题目对应的信息）
     *
     * @return
     */

    @GetMapping("/selectAll")
    @ApiOperation(value = "级联查询----全体")
    public Message selectAll() {
        List<QuestionEX> list = questionService.selectAll();
        return MessageUtil.success(list);
    }

    /**
     * 级联删除
     *
     * @param id：主键
     * @return
     */
    @GetMapping("/deleteById")
    @ApiOperation("/级联删除--删除题目")
    @ApiImplicitParam(name = "id", value = "题目id", paramType = "query", dataType = "int", required = true)
    public Message deleteById(int id) {
        questionService.deleteById(id);
        return MessageUtil.success(DaoUtil.DELETE);
    }

    /**
     * 多项删除（批量操作）
     */
    @GetMapping("/deleteBatch")
    @ApiOperation("批量删除+级联删除")
    public Message deleteBatch(int ids[]) {
        for (int id : ids) {
            questionService.deleteById(id);
        }
        return MessageUtil.success(DaoUtil.DELETE);
    }

    /**
     * 添加数据
     * 将请求体json转换成
     *
     * @PostMapping 与 @RequestBody 一起用
     */
    @PostMapping("/addQuestion")
    public Message addQuestion(Question question, @RequestBody List<Options> list) {
        questionService.insertQuestion(question,list);
        return MessageUtil.success();
    }
}
