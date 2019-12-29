package xyz.lightseekers.maven_school.mapper.ex;


import org.springframework.stereotype.Repository;
import xyz.lightseekers.maven_school.bean.ex.DepartmentEX;

import java.util.List;

@Repository
public interface DepartmentEXMapper {
    List<DepartmentEX> findAll() throws RuntimeException;
    List<DepartmentEX> selectnameOrdep(String word) throws RuntimeException;
    List<DepartmentEX> selectname(String word) throws RuntimeException;
    List<DepartmentEX> selectdep(String word) throws RuntimeException;

}
