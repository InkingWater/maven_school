package xyz.lightseekers.maven_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lightseekers.maven_school.bean.Questionnaire;
import xyz.lightseekers.maven_school.bean.QuestionnaireExample;
import xyz.lightseekers.maven_school.mapper.QuestionnaireMapper;
import xyz.lightseekers.maven_school.service.IQuestionnaireService;

import java.util.List;
@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService {

    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    @Override
    public List<Questionnaire> findAll() throws RuntimeException {
        QuestionnaireExample questionnaireExample = new QuestionnaireExample();
        List<Questionnaire> list = questionnaireMapper.selectByExample(questionnaireExample);
        return list;
    }
}
