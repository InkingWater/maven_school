package xyz.lightseekers.maven_school.mapper.ex;

import org.springframework.stereotype.Repository;
import xyz.lightseekers.maven_school.bean.ex.SurveyEXM;

import java.util.List;

@Repository
public interface SurveyEXMMapper {


    List<SurveyEXM> selectAll() throws RuntimeException;

    List<SurveyEXM>  selectByTeacherID(int id) throws RuntimeException;

    List<SurveyEXM>  selectByCourseID(int id) throws RuntimeException;

    List<SurveyEXM>  selectByClazzID(int id) throws RuntimeException;

    List<SurveyEXM>  selectByDepartmentID(int id) throws RuntimeException;

    SurveyEXM selectByIdStatus(int id) throws RuntimeException;

    void uodateStatus(String word) throws RuntimeException;
}


