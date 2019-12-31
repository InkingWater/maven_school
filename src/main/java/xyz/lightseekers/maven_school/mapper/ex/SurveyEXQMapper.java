package xyz.lightseekers.maven_school.mapper.ex;

import org.springframework.stereotype.Repository;
import xyz.lightseekers.maven_school.bean.ex.SurveyEXQ;

import java.util.List;

/**
 * 映射接口
 */
@Repository
public interface SurveyEXQMapper {
    SurveyEXQ selectById(int id) throws RuntimeException;
    List<SurveyEXQ> selectAll() throws RuntimeException;
    List<SurveyEXQ> searchWord(String word) throws RuntimeException;
    List<SurveyEXQ> searchByQuestionnaireId(int id) throws RuntimeException;
}
