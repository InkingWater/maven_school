package xyz.lightseekers.maven_school.mapper.ex;

import org.springframework.stereotype.Repository;
import xyz.lightseekers.maven_school.bean.Question;
import xyz.lightseekers.maven_school.bean.ex.QuestionEX;

/**
 * @Author: ZhiliangJia
 * @Description:
 * @Date:Create in 20:52 2019/12/29
 * @Modified User:
 */
@Repository
public interface QuestionEXMapper {
    QuestionEX selectById(int id) throws RuntimeException;
}
