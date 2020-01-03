package xyz.lightseekers.maven_school.mapper.ex;

import org.springframework.stereotype.Repository;
import xyz.lightseekers.maven_school.bean.ex.ClazzEXQ;

import java.util.List;

@Repository
public interface ClazzEXQMapper {
    List<ClazzEXQ> selectClazz() throws RuntimeException;

    List<ClazzEXQ> selectClazzByDeId(Integer departmentId) throws RuntimeException;

    List<ClazzEXQ> selectClazzByName(String name) throws RuntimeException;

    List<ClazzEXQ> selectClazzById(Integer id) throws RuntimeException;
}
