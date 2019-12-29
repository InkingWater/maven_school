package xyz.lightseekers.maven_school.mapper.ex;

import org.springframework.web.bind.annotation.RequestMapping;
import xyz.lightseekers.maven_school.bean.Course;

import java.util.List;

@RequestMapping
public interface CourseMapperEX {


    List<Course> selectNameOrDescription(String word) throws RuntimeException;
    List<Course> selectName(String word) throws RuntimeException;
    List<Course> selectDescription(String word) throws  RuntimeException;
}
