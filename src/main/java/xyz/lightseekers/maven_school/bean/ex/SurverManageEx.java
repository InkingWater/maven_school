package xyz.lightseekers.maven_school.bean.ex;

import xyz.lightseekers.maven_school.bean.Clazz;
import xyz.lightseekers.maven_school.bean.Course;
import xyz.lightseekers.maven_school.bean.Department;
import xyz.lightseekers.maven_school.bean.Teacher;

import java.util.Date;

public class SurverManageEx {
    private Integer id;

    private String status;
    private Integer code;
    private Date surveyday;

    private Integer departmentId;

    private Integer courseId;

    private Integer clazzId;

    private Integer userId;

    private Integer questionnaireId;
    private Double average;

    private Department department;

    private Clazz clazz;

    private Course course;

    private QuestionnaireEX questionnaireEX;

    private Teacher teacher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Date getSurveyday() {
        return surveyday;
    }

    public void setSurveyday(Date surveyday) {
        this.surveyday = surveyday;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getClazzId() {
        return clazzId;
    }

    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public QuestionnaireEX getQuestionnaireEX() {
        return questionnaireEX;
    }

    public void setQuestionnaireEX(QuestionnaireEX questionnaireEX) {
        this.questionnaireEX = questionnaireEX;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
