package xyz.lightseekers.maven_school.mapper.ex;

import java.util.List;

public interface TeacherEXMapper {
    //搜索栏 空+不空
    List<TeacherEXMapper> selectGender(String word) throws RuntimeException;
}