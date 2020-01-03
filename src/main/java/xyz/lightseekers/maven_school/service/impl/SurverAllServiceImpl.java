package xyz.lightseekers.maven_school.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lightseekers.maven_school.bean.ex.SurverAllEx;
import xyz.lightseekers.maven_school.mapper.ex.SurverAllExMapper;
import xyz.lightseekers.maven_school.service.ISurverAllService;

import java.util.List;

@Service
public class SurverAllServiceImpl implements ISurverAllService {

    @Autowired
    private SurverAllExMapper surverAllExMapper;

    @Override
    public List<SurverAllEx> findAll() throws RuntimeException {
        return surverAllExMapper.findAll();
    }

    @Override
    public SurverAllEx findASurverById(int id) throws RuntimeException {
        return surverAllExMapper.findASurverById(id);
    }

    @Override
    public List<SurverAllEx> search(String department,String clazz,String course,String questionnaire, String word) throws RuntimeException {
        if(word==null||"".equals(word))
            return findAll();
        else {
            word= word==null?"":word;
            word = "%"+word+"%";
            return surverAllExMapper.search(department, clazz, course, questionnaire, word);
        }
    }


}
