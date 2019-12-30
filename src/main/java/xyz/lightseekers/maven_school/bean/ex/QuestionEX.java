package xyz.lightseekers.maven_school.bean.ex;

import xyz.lightseekers.maven_school.bean.Options;

import java.util.List;

/**
 * @Author: ZhiliangJia
 * @Description:
 * @Date:Create in 20:48 2019/12/29
 * @Modified User:
 */
public class QuestionEX {
    private Integer id;

    private String name;

    private String type;

    private List<Options> options;

    @Override
    public String toString() {
        return "QuestionEX{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", options=" + options +
                '}';
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Options> getOptions() {
        return options;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }
}
