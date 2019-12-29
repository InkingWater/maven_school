package xyz.lightseekers.maven_school.bean.ex;

import xyz.lightseekers.maven_school.bean.Department;

import java.io.Serializable;

public class RegionEX implements Serializable {
    private Integer id;

    private String name;

    private String description;

    private String telepone;

    private String copyright;

    private String address;

    private Department department;

    @Override
    public String toString() {
        return "RegionEX{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", telepone='" + telepone + '\'' +
                ", copyright='" + copyright + '\'' +
                ", address='" + address + '\'' +
                ", department=" + department +
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTelepone() {
        return telepone;
    }

    public void setTelepone(String telepone) {
        this.telepone = telepone;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}