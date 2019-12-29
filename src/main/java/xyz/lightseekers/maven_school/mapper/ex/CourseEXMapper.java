package xyz.lightseekers.maven_school.mapper.ex;

import xyz.lightseekers.maven_school.bean.Course;

import java.util.List;

public interface CourseEXMapper {


    List<Course> selectNameOrDescription(String word) throws RuntimeException;
    List<Course> selectName(String word) throws RuntimeException;
    List<Course> selectDescription(String word) throws  RuntimeException;
}
