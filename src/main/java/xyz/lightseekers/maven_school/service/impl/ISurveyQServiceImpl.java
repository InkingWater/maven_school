package xyz.lightseekers.maven_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lightseekers.maven_school.bean.Questionnaire;
import xyz.lightseekers.maven_school.bean.QuestionnaireExample;
import xyz.lightseekers.maven_school.bean.Survey;
import xyz.lightseekers.maven_school.bean.ex.SurveyEXQ;
import xyz.lightseekers.maven_school.mapper.QuestionnaireMapper;
import xyz.lightseekers.maven_school.mapper.SurveyMapper;
import xyz.lightseekers.maven_school.mapper.ex.SurveyEXQMapper;
import xyz.lightseekers.maven_school.service.ISurveyQService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ISurveyQServiceImpl implements ISurveyQService {

    @Autowired
    private SurveyEXQMapper surveyEXQMapper;

    @Autowired
    private SurveyMapper surveyMapper;
    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    @Override
    public SurveyEXQ selectById(int id) throws RuntimeException {
        return surveyEXQMapper.selectById(id);
    }

    @Override
    public List<SurveyEXQ> selectAll() throws RuntimeException {
        return surveyEXQMapper.selectAll();
    }

    @Override
    public Integer startOrStop(int id) throws RuntimeException {
        //先确定改哪个值
        Survey survey = surveyMapper.selectByPrimaryKey(id);
        if ("待开启".equals(survey.getStatus())) {
            Random random = new Random();
            int s = random.nextInt(9999) % (9000) + 1000;
            survey.setCode(s);
            survey.setStatus("开启");
            surveyMapper.updateByPrimaryKey(survey);
            return surveyMapper.selectByPrimaryKey(id).getCode();
        } else if ("开启".equals(survey.getStatus())) {
            survey.setStatus("待审核");
            surveyMapper.updateByPrimaryKey(survey);
            return null;
        }
        return null;
    }
    //默认按照问卷查找
    @Override
    public List<SurveyEXQ> searchByName(String word) throws RuntimeException {
        if (word==null||"".equals(word)){
            return surveyEXQMapper.selectAll();
        }
        else {
            word = "%" + word +"%";
            //先在Questionnaire中模糊查询，将结果存到List集合中，使用andNameLike方法
            QuestionnaireExample questionnaireExample=new QuestionnaireExample();
            questionnaireExample.createCriteria().andNameLike(word);
            List<Questionnaire> questionnaires = questionnaireMapper.selectByExample(questionnaireExample);
            //然后在survey表中通过获取查询到的Question_Id来进行查询survey,然后存到List集合中
            List<SurveyEXQ> list = new ArrayList<>();
            for (int i = 0; i < questionnaires.size(); i++) {
                list.addAll(surveyEXQMapper.searchByQuestionnaireId(questionnaires.get(i).getId()));
            }
            return list;
        }
    }
}
