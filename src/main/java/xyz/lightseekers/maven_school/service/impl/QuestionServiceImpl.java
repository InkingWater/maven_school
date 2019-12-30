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

    /**
     * 通过题目主键来获取题目数据，同时包括相应选项数据（双表查询）
     * @param id
     * @return
     */
    @Override
    public QuestionEX selectById(int id) {
        return questionEXMapper.selectById(id);
    }

    /**
     * 获取全部题目数据，同时包括相应选项数据（双表查询）
     * @return
     * @throws RuntimeException
     */
    @Override
    public List<QuestionEX> selectAll() throws RuntimeException {
        List<QuestionEX> list =questionEXMapper.selectAll();
        return list;
    }

    /**
     * 通过主键删除题目数据，同时级联删除相关选项数据（级联删除）
     * @param id
     * @throws RuntimeException
     */
    @Override
    public void deleteById(int id) throws RuntimeException {
        questionMapper.deleteByPrimaryKey(id);
        OptionsExample example = new OptionsExample();
        example.createCriteria().andQuestionIdEqualTo(id);
        optionsMapper.deleteByExample(example);
    }

    /**
     * 更新题目数据（单表操作）
     * @param question
     * @throws RuntimeException
     */
    @Override
    public void updateById(Question question) throws RuntimeException {
        questionMapper.updateByPrimaryKey(question);
    }


    /**
     * 通过主键删除选项（单表操作）
     * @param id
     * @throws RuntimeException
     */
    @Override
    public void deleteOptionsById(int id) throws RuntimeException {
        optionsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加题目数据，同时添加选项集合数据
     * @param question 题目数据
     * @param list 相应的选项数据
     * @throws RuntimeException
     */
    @Override
    public void insertQuestion(Question question,List<Options> list) throws RuntimeException {
        questionMapper.insert(question);
        for (Options options:list){
            options.setQuestionId(question.getId());
            optionsMapper.insert(options);
        }
    }


//    /**
//     * 失败，修改指定问题的选项时，无法获取选项的主键，
//     * 解决办法，先通过选项外键id删除所有选项，再创建所有选项
//     * @param question
//     * @param list
//     * @throws RuntimeException
//     */
//    @Override
//    public void updateQuestionPlus(Question question, List<Options> list) throws RuntimeException {
//        questionMapper.updateByPrimaryKey(question);
//        for (Options options:list){
//            options.setQuestionId(question.getId());
//            optionsMapper.updateByPrimaryKey(options);
//        }
//    }
}
