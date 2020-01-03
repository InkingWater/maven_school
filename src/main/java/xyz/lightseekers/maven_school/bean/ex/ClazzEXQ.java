package xyz.lightseekers.maven_school.bean.ex;

import java.util.List;

public class ClazzEXQ {
    private Integer id;
    private String name;
    private List<SurveyEXQ> list;
    private double min;
    private double recent;
    private double average;
    private Integer departmentId;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public double getRecent() {
        return recent;
    }

    public void setRecent(double recent) {
        this.recent = recent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SurveyEXQ> getList() {
        return list;
    }

    public void setList(List<SurveyEXQ> list) {
        this.list = list;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
