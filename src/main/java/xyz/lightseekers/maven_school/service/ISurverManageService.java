package xyz.lightseekers.maven_school.service;

import xyz.lightseekers.maven_school.bean.Survey;

public interface ISurverManageService  {
    String  addOrUpdate(Survey survey) throws RuntimeException;
}
