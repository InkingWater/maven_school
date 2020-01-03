package xyz.lightseekers.maven_school.service;

import org.apache.ibatis.annotations.Param;
import xyz.lightseekers.maven_school.bean.ex.SurverAllEx;

import java.util.List;

public interface ISurverAllService {
    List<SurverAllEx> findAll() throws RuntimeException;
    SurverAllEx findASurverById(int id) throws RuntimeException;
    List<SurverAllEx> search(String department,String clazz,String course,String questionnaire, String word) throws RuntimeException;
}
