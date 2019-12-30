package xyz.lightseekers.maven_school.service;


import xyz.lightseekers.maven_school.bean.Department;
import xyz.lightseekers.maven_school.bean.ex.DepartmentEX;

import java.util.List;

public interface IDepartmentService {
    List<DepartmentEX> findAllDepartmentEX() throws RuntimeException;
    List<DepartmentEX> finder(String key,String word) throws RuntimeException;
    void saveOrUpdate(Department department) throws RuntimeException;
    void deleteById(int id) throws RuntimeException;
    String deleteMore(int id[]) throws RuntimeException;

}
