package xyz.lightseekers.maven_school.mapper.ex;

import xyz.lightseekers.maven_school.bean.ex.TeacherEX;

import java.util.List;

public interface TeacherEXMapper {
    //搜索栏 空+不空
    List<TeacherEX> selectGender(String word) throws RuntimeException;

    //搜索栏 空+空
    List<TeacherEX> selectAll() throws RuntimeException;
}