package xyz.lightseekers.maven_school.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.lightseekers.maven_school.bean.Options;
import xyz.lightseekers.maven_school.bean.Question;
import xyz.lightseekers.maven_school.bean.ex.QuestionEX;
import xyz.lightseekers.maven_school.service.IOptionsService;
import xyz.lightseekers.maven_school.service.IQuestionService;
import xyz.lightseekers.maven_school.service.impl.OptionsServiceImpl;
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
    private OptionsServiceImpl optionService;

    /**
     * 根据主键选择问题
     *
     * @param id：主键
     * @return
     */
    @GetMapping("/selectById")
    @ApiOperation(value = "根据编号选择问题")
    @ApiImplicitParam(name = "id", value = "题目id", paramType = "query", dataType = "int", required = true)
    public Message selectById(int id) {
        return MessageUtil.success(questionService.selectById(id));
    }

    /**
     * 根据主键删除问题（单表）
     */
    @GetMapping("/deleteOptionById")
    @ApiOperation(value = "根据主键删除选项")
    @ApiImplicitParam(name = "id", value = "选项id", paramType = "query", dataType = "int", required = true)
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
    @ApiOperation("级联删除--删除题目")
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
    @ApiImplicitParam(name = "ids", value = "删除的题目集合", paramType = "query", dataType = "Array[int]")
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
    @ApiOperation(value = "添加一条题目数据+多个选项数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "题目编号", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "name", value = "题目编号", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "type", value = "题目类型", paramType = "query", dataType = "String")
    })
    public Message addQuestion(Question question, @RequestBody List<Options> list) {
        questionService.insertQuestion(question, list);
        return MessageUtil.success();
    }

    /**
     * @param question 传入修改的信息
     * @return
     */
    @PostMapping("/updateQuestion")
    @ApiOperation(value = "修改问题")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "题目编号", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "name", value = "题目编号", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "type", value = "题目类型", paramType = "query", dataType = "String"),
    })
    public Message updateQuestion(Question question) {
        questionService.updateById(question);
        return MessageUtil.success(DaoUtil.UPDATE);
    }

    @PostMapping("/updateOption")
    @ApiOperation(value = "修改选项")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "选项编号", paramType = "query", dataType = "int", required = true),
            @ApiImplicitParam(name = "label", value = "选项代码", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "name", value = "选项等级", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "score", value = "选项分值", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "questionId", value = "所属题目编号", paramType = "query", dataType = "int")
    })
    public Message updateOption(Options options) {
        optionService.updateOption(options);
        return MessageUtil.success(DaoUtil.UPDATE);
    }

/**
 * 无效方法
 */
//    @PostMapping("/updateBoth")
//    public Message updateBoth(Question question,@RequestBody List<Options> list){
//        questionService.updateQuestionPlus(question,list);
//        return MessageUtil.success(DaoUtil.UPDATE);
//    }
}
