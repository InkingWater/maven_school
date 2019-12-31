package xyz.lightseekers.maven_school.mapper.ex;

import xyz.lightseekers.maven_school.bean.ex.AnswerEX;

import java.util.List;

public interface AnswerEXMapper {

    List<AnswerEX> selectBySurveyId(int id) throws RuntimeException;

    int deleteAnswerByID(int id) throws RuntimeException;

    void updateAnswer(String word,int id) throws RuntimeException;

}
