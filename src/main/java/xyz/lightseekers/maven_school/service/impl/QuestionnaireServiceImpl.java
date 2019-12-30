package xyz.lightseekers.maven_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lightseekers.maven_school.bean.Qqn;
import xyz.lightseekers.maven_school.bean.QqnExample;
import xyz.lightseekers.maven_school.bean.Questionnaire;
import xyz.lightseekers.maven_school.bean.QuestionnaireExample;
import xyz.lightseekers.maven_school.bean.ex.QuestionnaireEX;
import xyz.lightseekers.maven_school.mapper.QqnMapper;
import xyz.lightseekers.maven_school.mapper.QuestionnaireMapper;
import xyz.lightseekers.maven_school.mapper.ex.QuestionnaireEXMapper;
import xyz.lightseekers.maven_school.service.IQuestionnaireService;
import xyz.lightseekers.maven_school.util.DaoUtil;

import java.util.Date;
import java.util.List;
@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService {

    @Autowired
    private QuestionnaireMapper questionnaireMapper;
    @Autowired
    private QuestionnaireEXMapper questionnaireEXMapper;
    @Autowired
    private QqnMapper qqnMapper;

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
    public QuestionnaireEX findAQuestionnaire(int id) throws RuntimeException {
        return questionnaireEXMapper.findAQuestionnaire(id);
    }

    @Override
    public String addOrUpdate(Questionnaire questionnaire, int ids[]) throws RuntimeException {
            if(questionnaire.getId()==null){
                questionnaire.setDate(new Date());
                questionnaireEXMapper.insert(questionnaire);
                for (int i=0;i<ids.length;i++)
                    questionnaireEXMapper.insertIntoQqn(ids[i],questionnaire.getId());
                return DaoUtil.messageString(1+ids.length,DaoUtil.INSERT);
            }else{
                questionnaire.setDate(new Date());
                questionnaireMapper.updateByPrimaryKey(questionnaire);
                QqnExample qqnExample =new QqnExample();
                qqnExample.createCriteria().andQuestionnaireIdEqualTo(questionnaire.getId());
                qqnMapper.deleteByExample(qqnExample);
                for (int i=0;i<ids.length;i++)
                    questionnaireEXMapper.insertIntoQqn(ids[i],questionnaire.getId());

                return DaoUtil.messageString(1+ids.length,DaoUtil.UPDATE);
            }



    }


}
