package xyz.lightseekers.maven_school.mapper.ex;

import org.springframework.stereotype.Repository;
import xyz.lightseekers.maven_school.bean.ex.ClazzEx;

import java.util.List;

@Repository
public interface ClazzExMapper {
    List<ClazzEx> findAll() throws RuntimeException;
    ClazzEx findById(int id) throws  RuntimeException;
    List<ClazzEx> findByName(String word) throws RuntimeException;
    List<ClazzEx> findByTeacher(String word) throws RuntimeException;
    List<ClazzEx> findByNameOrTeacher(String word) throws RuntimeException;
}
