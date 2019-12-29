package xyz.lightseekers.maven_school.service;

import xyz.lightseekers.maven_school.bean.Course;
import xyz.lightseekers.maven_school.bean.Region;

import java.util.List;

public interface ICourseService {

  List<Course> findAll() throws RuntimeException;
  List<Course> search(String key, String word) throws RuntimeException;

    String insertOrUpdate(Course course) throws RuntimeException;
    String deleteById(int id);

    String deleteBatch(int[] ints)throws RuntimeException;
}
