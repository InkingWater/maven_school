package xyz.lightseekers.maven_school.service;

import xyz.lightseekers.maven_school.bean.Clazz;
import xyz.lightseekers.maven_school.bean.ex.ClazzEx;

import java.util.List;

public interface IClazzService {
    String deleteById(int id) throws RuntimeException;
    String addOrUpdate(Clazz clazz) throws RuntimeException;
    String deleteMany(int id[]) throws RuntimeException;
    List<ClazzEx> findAll() throws RuntimeException;
    ClazzEx findById(int id) throws RuntimeException;
    List<ClazzEx> findByCondi(String key,String word) throws RuntimeException;


}
