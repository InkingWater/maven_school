package xyz.lightseekers.maven_school.service;

import xyz.lightseekers.maven_school.bean.Survey;
import xyz.lightseekers.maven_school.bean.ex.SurverManageEx;

import java.util.List;

public interface ISurverManageService  {
    String  addOrUpdate(Survey survey) throws RuntimeException;
    String deleteById(int id) throws  RuntimeException;
    String deleteMany(int id[])throws RuntimeException;

    List<SurverManageEx> findAll() throws RuntimeException;
    SurverManageEx findASurverById(int id) throws RuntimeException;

    List<SurverManageEx> search(String word) throws RuntimeException;

}
