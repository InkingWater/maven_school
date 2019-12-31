package xyz.lightseekers.maven_school.web.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lightseekers.maven_school.bean.Teacher;
import xyz.lightseekers.maven_school.bean.ex.AnswerEX;
import xyz.lightseekers.maven_school.bean.ex.SurveyEXM;
import xyz.lightseekers.maven_school.service.IReviewService;
import xyz.lightseekers.maven_school.util.Message;
import xyz.lightseekers.maven_school.util.MessageUtil;

import java.util.List;

@RestController
@RequestMapping(value = "review")
@Api(description = "课调审核")
public class ReviewController {

    @Autowired
    private IReviewService iReviewService;


    @GetMapping("/selectAll")
    @ApiOperation(value = "查找所有的课调")
    public Message selectAll(){
        List<SurveyEXM> surveys = iReviewService.selectAll();
        return MessageUtil.success(surveys);
    }

    @GetMapping("/selectByCon")
    @ApiOperation(value = "条件查找()")
    public Message selectByCon(String keyWord){
        List<SurveyEXM> surveyEXMS = iReviewService.selectByCon(keyWord);

        return  MessageUtil.success(surveyEXMS);
    }


    @GetMapping("/selectTeacherName")
    @ApiOperation(value = "老师姓名")

    public Message selectTeacherName(String keyWord){
        List<Teacher> teachers = iReviewService.selectByTeacherName(keyWord);
        return MessageUtil.success(teachers);
    }



    @GetMapping("/selectBySur")
    @ApiOperation(value = "查找调查答案")
    public Message selectBySur(int id){
        List<AnswerEX> answerEXES = iReviewService.selectBySur(id);
        return MessageUtil.success(answerEXES);
    }

    @GetMapping("/deleteAnswer")
    @ApiOperation(value = "根据id删除")
    public Message deleteAnswer(int id){
        return MessageUtil.success(iReviewService.deleteAnswerById(id));
    }


    @PostMapping("/updateAnswer")
    @ApiOperation(value = "修改答案有关")
    public Message updateAnswer(String word, int id){
        iReviewService.updateAnswer(word,id);
        return MessageUtil.success("修改成功");
    }
}
