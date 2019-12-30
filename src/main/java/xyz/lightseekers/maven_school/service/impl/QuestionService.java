package xyz.lightseekers.maven_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lightseekers.maven_school.bean.ex.QuestionEX;
import xyz.lightseekers.maven_school.mapper.ex.QuestionEXMapper;
import xyz.lightseekers.maven_school.service.IQuestionService;
import xyz.lightseekers.maven_school.util.DaoUtil;

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


    @Override
    public QuestionEX selectById(int id) {
        return questionEXMapper.selectById(id);
    }

}
