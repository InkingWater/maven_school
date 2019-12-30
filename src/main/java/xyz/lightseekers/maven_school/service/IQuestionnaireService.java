package xyz.lightseekers.maven_school.service;

import xyz.lightseekers.maven_school.bean.Questionnaire;
import xyz.lightseekers.maven_school.bean.ex.QuestionnaireEX;

import java.util.List;

public interface IQuestionnaireService {
    List<Questionnaire> findAll() throws RuntimeException;

    List<Questionnaire> search(String word) throws RuntimeException;
    QuestionnaireEX findAQuestionnaire(int id) throws RuntimeException;
    String addOrUpdate(Questionnaire questionnaire,int ids[]) throws RuntimeException;



    void deleteByid(int id) throws RuntimeException;

    String deleteM(int id[]) throws RuntimeException;

    void deleteS(int id) throws RuntimeException;

    void deleteByQqn(int id) throws RuntimeException;


}
