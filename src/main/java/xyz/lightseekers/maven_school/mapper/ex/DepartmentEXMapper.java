package xyz.lightseekers.maven_school.mapper.ex;


import org.springframework.stereotype.Repository;
import xyz.lightseekers.maven_school.bean.ex.DepartmentEX;

import java.util.List;

@Repository
public interface DepartmentEXMapper {
    List<DepartmentEX> findAll();
    List<DepartmentEX> selectnameOrdep(String word);
    List<DepartmentEX> selectname(String word);
    List<DepartmentEX> selectdep(String word);

}
