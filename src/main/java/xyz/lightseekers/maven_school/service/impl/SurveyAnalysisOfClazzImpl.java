package xyz.lightseekers.maven_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lightseekers.maven_school.bean.ex.ClazzEXQ;
import xyz.lightseekers.maven_school.mapper.ex.ClazzEXQMapper;
import xyz.lightseekers.maven_school.service.ISurveyAnalysisOfClazzService;

import java.util.List;

@Service
public class SurveyAnalysisOfClazzImpl implements ISurveyAnalysisOfClazzService {

    @Autowired
    private ClazzEXQMapper clazzEXQMapper;


    @Override
    public List<ClazzEXQ> selectClazz() throws RuntimeException {
        List<ClazzEXQ> list = clazzEXQMapper.selectClazz();
        return list;
    }

    @Override
    public List<ClazzEXQ> searchClazz(Integer grade, Integer clazz, String word) throws RuntimeException {
        //都无参数
        if (("".equals(grade) || grade == null) && ("".equals(clazz) || clazz == null) && ("".equals(word) || word == null)) {
            return clazzEXQMapper.selectClazz();
            //如果grade有参数 其余为空
        } else if (("".equals(clazz) || clazz == null) && ("".equals(word) || word == null) && (!"".equals(grade))) {
            return clazzEXQMapper.selectClazzByDeId(grade);
            //如果word有参数 其余无所谓
        } else if (!"".equals(word) && ("".equals(clazz) || clazz == null)) {
            word = "%" + word + "%";
            return clazzEXQMapper.selectClazzByName(word);
        } else if (("".equals(word) || word == null) && ("".equals(grade) || grade == null) && !"".equals(clazz)) {
            return clazzEXQMapper.selectClazzById(clazz);
        } else {
            return null;
        }
    }

//    @Override
//    public List<ClazzEXQ> test(String word) throws RuntimeException {
//        return clazzEXQMapper.selectClazzByName("%" + word + "%");
//    }
}
