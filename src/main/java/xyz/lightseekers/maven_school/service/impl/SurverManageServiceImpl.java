package xyz.lightseekers.maven_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lightseekers.maven_school.bean.Survey;
import xyz.lightseekers.maven_school.mapper.SurveyMapper;
import xyz.lightseekers.maven_school.service.ISurverManageService;

@Service
public class SurverManageServiceImpl implements ISurverManageService {

    @Autowired
    private SurveyMapper surveyMapper;

    @Override
    public String addOrUpdate(Survey survey) throws RuntimeException {
        if(survey.getId()==null){
            return null;
        }else{
            return null;
        }


    }
}
