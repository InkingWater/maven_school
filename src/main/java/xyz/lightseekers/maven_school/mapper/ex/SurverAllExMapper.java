package xyz.lightseekers.maven_school.mapper.ex;

import org.apache.ibatis.annotations.Param;
import xyz.lightseekers.maven_school.bean.ex.SurverAllEx;

import java.util.List;

public interface SurverAllExMapper {
    List<SurverAllEx> findAll() throws RuntimeException;
    SurverAllEx findASurverById(int id) throws RuntimeException;
    List<SurverAllEx> search(@Param("department") String department, @Param("clazz") String clazz,@Param("course") String course,@Param("questionnaire") String questionnaire, String word) throws RuntimeException;
}
