package xyz.lightseekers.maven_school.service;

import xyz.lightseekers.maven_school.bean.Options;
import xyz.lightseekers.maven_school.bean.Question;
import xyz.lightseekers.maven_school.bean.ex.OptionsEX;
import xyz.lightseekers.maven_school.bean.ex.QuestionEX;

import java.util.List;

/**
 * @Author: ZhiliangJia
 * @Description:
 * @Date:Create in 21:01 2019/12/29
 * @Modified User:
 */
public interface IQuestionService {
    QuestionEX selectById(int id);

    String insertOrUpdateQuestion(QuestionEX questionEX) throws RuntimeException;
    String insertOptions(OptionsEX optionsEX) throws RuntimeException;

    List<QuestionEX> findAll() throws RuntimeException;

    List<QuestionEX> selectByCon(String con) throws RuntimeException;

}
