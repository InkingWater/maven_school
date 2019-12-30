package xyz.lightseekers.maven_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lightseekers.maven_school.bean.Questionnaire;
import xyz.lightseekers.maven_school.bean.QuestionnaireExample;
import xyz.lightseekers.maven_school.mapper.QuestionnaireMapper;
import xyz.lightseekers.maven_school.mapper.ex.QuestionnaireEXMapper;
import xyz.lightseekers.maven_school.service.IQuestionnaireService;
import xyz.lightseekers.maven_school.util.DaoUtil;

import java.util.List;
@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService {

    @Autowired
    private QuestionnaireMapper questionnaireMapper;
    @Autowired
    private QuestionnaireEXMapper questionnaireEXMapper;

    @Override
    public List<Questionnaire> findAll() throws RuntimeException {
        QuestionnaireExample questionnaireExample = new QuestionnaireExample();
        List<Questionnaire> list = questionnaireMapper.selectByExample(questionnaireExample);
        return list;
    }

    @Override
    public List<Questionnaire> search(String word) throws RuntimeException {

        if(word==null||"".equals(word))
            return findAll();
        else {
            word= word==null?"":word;
            word = "%"+word+"%";
            return questionnaireEXMapper.search(word);
        }
    }

    @Override
    public void deleteByid(int id) throws RuntimeException {
        questionnaireMapper.deleteByPrimaryKey(id);
    }

    @Override
    public String deleteM(int[] id) throws RuntimeException {
        for (int i=0;i<id.length;i++){
            deleteS(id[i]);
            deleteByid(id[i]);
        }
        return DaoUtil.messageString(id.length,DaoUtil.DELETE);
    }

    @Override
    public void deleteS(int id) throws RuntimeException {
        questionnaireEXMapper.deletes(id);
    }



}
