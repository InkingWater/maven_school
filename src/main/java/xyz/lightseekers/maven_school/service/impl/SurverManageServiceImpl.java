package xyz.lightseekers.maven_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lightseekers.maven_school.bean.Survey;
import xyz.lightseekers.maven_school.bean.ex.SurverManageEx;
import xyz.lightseekers.maven_school.mapper.SurveyMapper;
import xyz.lightseekers.maven_school.mapper.ex.SurverManageExMapper;
import xyz.lightseekers.maven_school.service.ISurverManageService;
import xyz.lightseekers.maven_school.util.DaoUtil;

import java.util.Date;
import java.util.List;

@Service
public class SurverManageServiceImpl implements ISurverManageService {

    @Autowired
    private SurveyMapper surveyMapper;

    @Autowired
    private SurverManageExMapper surverManageExMapper;

    @Override
    public String addOrUpdate(Survey survey) throws RuntimeException {
        if(survey.getId()==null){
            survey.setSurveyday(new Date());
            return DaoUtil.messageString(surveyMapper.insert(survey),DaoUtil.INSERT);
        }else{
            survey.setSurveyday(new Date());
            return DaoUtil.messageString(surveyMapper.updateByPrimaryKey(survey),DaoUtil.UPDATE);
        }
    }

    @Override
    public String deleteById(int id) throws RuntimeException {
        return DaoUtil.messageString(surveyMapper.deleteByPrimaryKey(id),DaoUtil.DELETE);
    }

    @Override
    public String deleteMany(int[] id) throws RuntimeException {
        for (int i:id) {
            deleteById(i);
        }
        return DaoUtil.messageString(id.length,DaoUtil.DELETE);
    }

    @Override
    public List<SurverManageEx> findAll() throws RuntimeException {
        return surverManageExMapper.findAll();
    }

    @Override
    public SurverManageEx findASurverById(int id) throws RuntimeException {
        return surverManageExMapper.findASurverById(id);
    }

    @Override
    public List<SurverManageEx> search(String word) throws RuntimeException {
        if(word==null||"".equals(word))
            return findAll();
        else {
            word= word==null?"":word;
            word = "%"+word+"%";
            return surverManageExMapper.search(word);
        }
    }


}
