package xyz.lightseekers.maven_school.mapper.ex;

import org.springframework.stereotype.Repository;
import xyz.lightseekers.maven_school.bean.Question;
import xyz.lightseekers.maven_school.bean.Questionnaire;
import xyz.lightseekers.maven_school.bean.ex.QuestionnaireEX;

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
    void insert(Questionnaire questionnaire) throws RuntimeException;
    QuestionnaireEX findAQuestionnaire(int id) throws RuntimeException;
    void update(Questionnaire questionnaire) throws RuntimeException;
    void insertIntoQqn(int qid,int qnid) throws RuntimeException;
    void deleteqqnById(int id) throws RuntimeException;
}
