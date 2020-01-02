package xyz.lightseekers.maven_school.service;

import xyz.lightseekers.maven_school.bean.ex.SurveyEXQ;

import java.util.List;

public interface ISurveyQService {
    SurveyEXQ selectById(int id) throws RuntimeException;
    List<SurveyEXQ> selectAll() throws RuntimeException;
    Integer startOrStop(int id)throws RuntimeException;
    List<SurveyEXQ> searchByName(String word) throws RuntimeException;
    List<SurveyEXQ> selectAllByStatus() throws RuntimeException;

}
