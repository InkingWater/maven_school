package xyz.lightseekers.maven_school.mapper.ex;

import org.springframework.stereotype.Repository;
import xyz.lightseekers.maven_school.bean.Question;
import xyz.lightseekers.maven_school.bean.Questionnaire;

import java.util.List;

/**
 * @Author: ZhiliangJia
 * @Description:
 * @Date:Create in 21:17 2019/12/29
 * @Modified User:
 */
@Repository
public interface QuestionnaireEXMapper {
    List<Questionnaire> search(String word) throws RuntimeException;

    void deletes(int id) throws RuntimeException;
}
