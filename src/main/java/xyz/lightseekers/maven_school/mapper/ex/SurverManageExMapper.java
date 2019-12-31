package xyz.lightseekers.maven_school.mapper.ex;

import xyz.lightseekers.maven_school.bean.ex.SurverManageEx;

import java.util.List;

public interface SurverManageExMapper {
    List<SurverManageEx> findAll() throws RuntimeException;
    SurverManageEx findASurverById(int id) throws RuntimeException;
    List<SurverManageEx> search(String word) throws RuntimeException;
}
