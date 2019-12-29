package xyz.lightseekers.maven_school.service;

import xyz.lightseekers.maven_school.bean.Teacher;

import java.util.List;

public interface ITeacherService {
    //通过主键修改某条数据
    void saveOrUpdate(Teacher teacher)throws RuntimeException;
    //通过主键查找某条数据
    Teacher selectById(int id) throws RuntimeException;
    //通过主键删除某条数据
    void deleteById(int id) throws RuntimeException;
    //遍历全部数据----------同时应用于搜索栏“空+空”
    List<Teacher> findAll()throws RuntimeException;
    //搜索栏
    List<Teacher> search(String key,String word)throws RuntimeException;
}
