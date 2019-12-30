package xyz.lightseekers.maven_school.service;

import xyz.lightseekers.maven_school.bean.Questionnaire;

import java.util.List;

public interface IQuestionnaireService {
    List<Questionnaire> findAll() throws RuntimeException;

    List<Questionnaire> search(String word) throws RuntimeException;
}
