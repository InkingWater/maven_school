package xyz.lightseekers.maven_school.service.impl;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lightseekers.maven_school.bean.*;
import xyz.lightseekers.maven_school.bean.ex.AnswerEX;
import xyz.lightseekers.maven_school.bean.ex.SurveyEXM;
import xyz.lightseekers.maven_school.mapper.*;
import xyz.lightseekers.maven_school.mapper.ex.AnswerEXMapper;
import xyz.lightseekers.maven_school.mapper.ex.SurveyEXMMapper;
import xyz.lightseekers.maven_school.service.IReviewService;
import xyz.lightseekers.maven_school.util.DaoUtil;
import xyz.lightseekers.maven_school.util.Message;
import xyz.lightseekers.maven_school.util.MessageUtil;

import java.nio.file.LinkOption;
import java.util.ArrayList;
import java.util.List;

@Service

public class ReviewServiceImpl implements IReviewService {

    @Autowired
    private SurveyEXMMapper surveyEXMMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private AnswerEXMapper answerEXMapper;

    @Autowired
    private  QuestionnaireMapper questionnaireMapper;



    @Override
    public List<SurveyEXM> selectAll()  {


        List<SurveyEXM> list = surveyEXMMapper.selectAll();

        for (SurveyEXM surveyEXM : list) {
            Teacher teacher = teacherMapper.selectByPrimaryKey(surveyEXM.getUserId());
            surveyEXM.setTeacherName(teacher.getName());

            Course course = courseMapper.selectByPrimaryKey(surveyEXM.getCourseId());
            surveyEXM.setCourseName(course.getName());

            Department department = departmentMapper.selectByPrimaryKey(surveyEXM.getDepartmentId());
            surveyEXM.setDepartmentName(department.getName());

            Clazz clazz = clazzMapper.selectByPrimaryKey(surveyEXM.getClazzId());
            surveyEXM.setClazzName(clazz.getName());

        }
        return list;
    }


    @Override
    public List<SurveyEXM> selectByCon(String keyWord) throws RuntimeException {

        List<SurveyEXM> list = new ArrayList<>();
        if (keyWord == null || "".equals(keyWord)) {
               return selectAll();
        }else {}
//        List<Department> departments = selectByDepartmenName(keyWord);
//        List<Clazz> clazzes = selectByClazzName(keyWord);
        List<Course> courses = selectByCourseName(keyWord);
        List<Teacher> teachers =selectByTeacherName(keyWord);




//        for (Department department : departments) {
//            depqrtmentIDs.add(department.getId());
//        }
//
//        for (Clazz clazz : clazzes) {
//            clazzIDs.add(clazz.getId());
//        }
//
        for (Course cours : courses) {
            SurveyEXM  surveyEXM = surveyEXMMapper.selectByCourseID(cours.getId());
            System.out.println(cours.getId());
            System.out.println(surveyEXM);

            list.add(surveyEXM);
        }

       // SurveyEXM surveyEXM ;
        for (Teacher teacher : teachers) {
          SurveyEXM  surveyEXM = surveyEXMMapper.selectByTeacherID(teacher.getId());
          System.out.println(teacher.getId());
          System.out.println(surveyEXM);

            list.add(surveyEXM);
            System.out.println(teacher.getId());
          //  teacherIDs.add(teacher.getId());
        }

 //       System.out.println(teacherIDs);



//        List<SurveyEXM> listByteacher = null;
//
//        List<SurveyEXM> listByCourse = null;
//
//        List<SurveyEXM> listByDepartment = null;
//
//        List<SurveyEXM> listByClazz = null;



//        for (Integer teacherID : teacherIDs) {
//
//        }

//        for (SurveyEXM surveyEXM : list) {
//            Teacher teacher = teacherMapper.selectByPrimaryKey(surveyEXM.getUserId());
//            surveyEXM.setTeacherName(teacher.getName());
//
//            Course course = courseMapper.selectByPrimaryKey(surveyEXM.getCourseId());
//            surveyEXM.setCourseName(course.getName());
//
//            Department department = departmentMapper.selectByPrimaryKey(surveyEXM.getDepartmentId());
//            surveyEXM.setDepartmentName(department.getName());
//
//            Clazz clazz = clazzMapper.selectByPrimaryKey(surveyEXM.getClazzId());
//            surveyEXM.setClazzName(clazz.getName());
//
//        }


        return list;
    }

    @Override
    public List<Department> selectByDepartmenName(String name) throws RuntimeException {
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.createCriteria().andNameEqualTo(name);
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        return departments;
    }

    @Override
    public List<Clazz> selectByClazzName(String name) throws RuntimeException {
        ClazzExample clazzExample = new ClazzExample() ;
        clazzExample.createCriteria().andNameEqualTo(name);
        List<Clazz> clazzes = clazzMapper.selectByExample(clazzExample);
        return  clazzes;
    }

    @Override
    public List<Course> selectByCourseName(String name) throws RuntimeException {

        CourseExample courseExample = new CourseExample();
        courseExample.createCriteria().andNameEqualTo(name);
        List<Course> courses = courseMapper.selectByExample(courseExample);
        return courses;
    }

//    @Override
//    public List<SurveyEXM> selectByQuestonnaire(String Name) throws RuntimeException {
//        return null;
//    }

    @Override
    public List<Teacher> selectByTeacherName(String name) throws RuntimeException {
        TeacherExample teacherExample = new TeacherExample();
        teacherExample.createCriteria().andNameLike(name);
        List<Teacher> list = teacherMapper.selectByExample(teacherExample);
        return list;
    }

    @Override
    public List<AnswerEX> selectBySur(int id) throws RuntimeException {

        List<AnswerEX> list = answerEXMapper.selectBySurveyId(id);
        return list;
    }

    @Override
    public String deleteAnswerById(int id) throws RuntimeException {

        return DaoUtil.messageString(answerEXMapper.deleteAnswerByID(id),
                DaoUtil.DELETE);
    }

    @Override
    public void updateAnswer(String word, int id) throws RuntimeException {
        answerEXMapper.updateAnswer(word,id);

    }
}



