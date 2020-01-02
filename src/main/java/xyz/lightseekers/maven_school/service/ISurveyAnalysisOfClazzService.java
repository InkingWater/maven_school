package xyz.lightseekers.maven_school.service;

import xyz.lightseekers.maven_school.bean.ex.ClazzEXQ;

import java.util.List;

public interface ISurveyAnalysisOfClazzService {
    List<ClazzEXQ> selectClazz() throws RuntimeException;

    List<ClazzEXQ> searchClazz(Integer grade, Integer clazz, String word) throws RuntimeException;
//    List<ClazzEXQ> test(String string)throws RuntimeException;
}
