package xyz.lightseekers.maven_school.mapper.ex;

import org.springframework.stereotype.Repository;
import xyz.lightseekers.maven_school.bean.ex.SurveyEXM;

import java.util.List;

@Repository
public interface SurveyEXMMapper {


    List<SurveyEXM> selectAll() throws RuntimeException;

    SurveyEXM  selectByTeacherID(int id) throws RuntimeException;

    SurveyEXM  selectByCourseID(int id) throws RuntimeException;

    SurveyEXM  selectByClazzID(int id) throws RuntimeException;

    SurveyEXM  selectByDepartmentID(int id) throws RuntimeException;
}


