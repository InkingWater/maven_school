package xyz.lightseekers.maven_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lightseekers.maven_school.bean.Options;
import xyz.lightseekers.maven_school.bean.Question;
import xyz.lightseekers.maven_school.bean.ex.OptionsEX;
import xyz.lightseekers.maven_school.bean.ex.QuestionEX;
import xyz.lightseekers.maven_school.mapper.OptionsMapper;
import xyz.lightseekers.maven_school.mapper.ex.OptionsEXMapper;
import xyz.lightseekers.maven_school.mapper.ex.QuestionEXMapper;
import xyz.lightseekers.maven_school.service.IQuestionService;
import xyz.lightseekers.maven_school.util.DaoUtil;

import javax.naming.ldap.PagedResultsControl;
import java.util.List;

/**
 * @Author: ZhiliangJia
 * @Description:
 * @Date:Create in 21:02 2019/12/29
 * @Modified User:
 */
@Service
public class QuestionService implements IQuestionService {

    @Autowired
    private QuestionEXMapper questionEXMapper;

    @Autowired
    private OptionsEXMapper optionsEXMapper;

    @Override
    public String insertOrUpdateQuestion(QuestionEX questionEX) throws RuntimeException {
        if (questionEX == null) {
            throw new RuntimeException();
        }
        if (questionEX.getId() == null) {
            return DaoUtil.messageString(questionEXMapper.insertQuestion(questionEX),
                    DaoUtil.INSERT);
        } else {
            return DaoUtil.messageString(questionEXMapper.updateQuestion(questionEX),
                    DaoUtil.UPDATE);
        }
    }

    @Override
    public String insertOptions(OptionsEX optionsEX) throws RuntimeException {

        return DaoUtil.messageString(optionsEXMapper.insert(optionsEX),
                DaoUtil.INSERT);
    }

    @Override
    public QuestionEX selectById(int id) {
        return questionEXMapper.selectById(id);
    }

    @Override
    public List<QuestionEX> findAll() throws RuntimeException {
        List<QuestionEX> questions = questionEXMapper.findAll();
        return questions;
    }

    @Override
    public List<QuestionEX> selectByCon(String con) throws RuntimeException {
        con = con == null ? "" :con;

        if (con == null || "".equals(con)) {
            return findAll();
        }else {
            con = "%" + con +"%";
            return questionEXMapper.selectByName(con);
        }
    }
}
