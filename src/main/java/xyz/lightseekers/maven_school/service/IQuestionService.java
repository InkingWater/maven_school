package xyz.lightseekers.maven_school.service;

import xyz.lightseekers.maven_school.bean.Options;
import xyz.lightseekers.maven_school.bean.ex.QuestionEX;

/**
 * @Author: ZhiliangJia
 * @Description:
 * @Date:Create in 21:01 2019/12/29
 * @Modified User:
 */
public interface IQuestionService {
    QuestionEX selectById(int id);
}
