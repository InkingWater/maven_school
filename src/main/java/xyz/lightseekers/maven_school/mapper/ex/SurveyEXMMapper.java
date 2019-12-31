package xyz.lightseekers.maven_school.mapper.ex;

import xyz.lightseekers.maven_school.bean.Survey;
import xyz.lightseekers.maven_school.bean.SurveyExample;
import xyz.lightseekers.maven_school.bean.ex.SurveyEXM;

import java.util.List;

public interface SurveyEXMMapper {


    List<SurveyEXM> selectAll() throws RuntimeException;

    SurveyEXM  selectByTeacherID(int id) throws RuntimeException;

    SurveyEXM  selectByCourseID(int id) throws RuntimeException;

    SurveyEXM  selectByClazzID(int id) throws RuntimeException;

    SurveyEXM  selectByDepartmentID(int id) throws RuntimeException;
}


