package xyz.lightseekers.maven_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lightseekers.maven_school.bean.Options;
import xyz.lightseekers.maven_school.bean.OptionsExample;
import xyz.lightseekers.maven_school.bean.Question;
import xyz.lightseekers.maven_school.bean.QuestionExample;
import xyz.lightseekers.maven_school.bean.ex.QuestionEX;
import xyz.lightseekers.maven_school.mapper.OptionsMapper;
import xyz.lightseekers.maven_school.mapper.QuestionMapper;
import xyz.lightseekers.maven_school.mapper.ex.QuestionEXMapper;
import xyz.lightseekers.maven_school.service.IQuestionService;

import java.util.List;

/**
 * @Author: ZhiliangJia
 * @Description:
 * @Date:Create in 21:02 2019/12/29
 * @Modified User:
 */
@Service
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    private QuestionEXMapper questionEXMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private OptionsMapper optionsMapper;


    @Override
    public QuestionEX selectById(int id) {
        return questionEXMapper.selectById(id);
    }

    @Override
    public List<QuestionEX> selectAll() throws RuntimeException {
        List<QuestionEX> list =questionEXMapper.selectAll();
        return list;
    }

    //级联删除
    @Override
    public void deleteById(int id) throws RuntimeException {
        questionMapper.deleteByPrimaryKey(id);
        OptionsExample example = new OptionsExample();
        example.createCriteria().andQuestionIdEqualTo(id);
        optionsMapper.deleteByExample(example);
    }

    @Override
    public void deleteOptionsById(int id) throws RuntimeException {
        optionsMapper.deleteByPrimaryKey(id);
    }


    @Override
    public void insertQuestion(Question question,List<Options> list) throws RuntimeException {
        questionMapper.insert(question);
        for (Options options:list){
            options.setQuestionId(question.getId());
            optionsMapper.insert(options);
        }
    }
}
