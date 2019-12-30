package xyz.lightseekers.maven_school.bean.ex;
/**
 * 完全修改
 */

import java.io.Serializable;

public class OptionsEX implements Serializable {
    private Integer id;

    private String label;

    private String name;

    private Integer score;

    private Integer questionId;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "OptionsEX{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", questionId=" + questionId +
                '}';
    }
}
