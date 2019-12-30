package xyz.lightseekers.maven_school.bean.ex;

import java.util.Date;
import java.util.List;

/**
 * @Author: ZhiliangJia
 * @Description:
 * @Date:Create in 21:09 2019/12/29
 * @Modified User:
 */
public class QuestionnaireEX {
    private Integer id;

    private String name;

    private Date date;

    private String description;

    private List<QuestionEX> questionEXs;



    @Override
    public String toString() {
        return "QuestionnaireEX{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", questionEXs=" + questionEXs +
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<QuestionEX> getQuestionEXs() {
        return questionEXs;
    }

    public void setQuestionEXs(List<QuestionEX> questionEXs) {
        this.questionEXs = questionEXs;
    }
}
