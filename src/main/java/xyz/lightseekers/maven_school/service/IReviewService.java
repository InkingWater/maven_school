package xyz.lightseekers.maven_school.service;


import xyz.lightseekers.maven_school.bean.Clazz;
import xyz.lightseekers.maven_school.bean.Course;
import xyz.lightseekers.maven_school.bean.Department;
import xyz.lightseekers.maven_school.bean.Teacher;
import xyz.lightseekers.maven_school.bean.ex.AnswerEX;
import xyz.lightseekers.maven_school.bean.ex.SurveyEXM;

import java.util.List;

public interface IReviewService {


    /*
      查找的方法集合
     */
    List<SurveyEXM> selectAll() ;

    //List<String> returnTeacherName() throws RuntimeException;

    List<SurveyEXM> selectByCon(String keyWord) throws RuntimeException;

    List<Department> selectByDepartmenName(String name) throws RuntimeException;

    List<Clazz> selectByClazzName(String name) throws RuntimeException;

    List<Course> selectByCourseName(String name) throws RuntimeException;

   // List<SurveyEXM> selectByQuestonnaire(String Name) throws RuntimeException;

    List<Teacher> selectByTeacherName(String name) throws RuntimeException;

    List<AnswerEX> selectBySur(int id) throws RuntimeException;

    String deleteAnswerById(int id) throws RuntimeException;

    void updateAnswer(String word,int id) throws RuntimeException;

    String  updateStatus(int id, String word) throws RuntimeException;

 }