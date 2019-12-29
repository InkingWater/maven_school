package xyz.lightseekers.maven_school.bean.ex;

import xyz.lightseekers.maven_school.bean.Region;

import java.io.Serializable;

public class DepartmentEX implements Serializable {
    private Integer id;

    private String name;

    private Integer region;

    private String description;

    private Region regIon;

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

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Region getRegIon() {
        return regIon;
    }

    public void setRegIon(Region regIon) {
        this.regIon = regIon;
    }
}
