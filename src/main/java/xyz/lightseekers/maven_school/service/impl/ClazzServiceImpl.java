package xyz.lightseekers.maven_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lightseekers.maven_school.bean.Clazz;
import xyz.lightseekers.maven_school.bean.ex.ClazzEx;
import xyz.lightseekers.maven_school.mapper.ClazzMapper;
import xyz.lightseekers.maven_school.mapper.ex.ClazzExMapper;
import xyz.lightseekers.maven_school.service.IClazzService;
import xyz.lightseekers.maven_school.util.DaoUtil;

import java.util.List;
@Service
public class ClazzServiceImpl implements IClazzService {

    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private ClazzExMapper clazzExMapper;

    @Override
    public String deleteById(int id) throws RuntimeException {
        return DaoUtil.messageString(clazzMapper.deleteByPrimaryKey(id),DaoUtil.DELETE);
    }

    @Override
    public String addOrUpdate(Clazz clazz) throws RuntimeException {
        if (clazz==null) throw new RuntimeException();
        if(clazz.getId()==null){
            clazz.setServeNumber(0);
            return DaoUtil.messageString(clazzMapper.insert(clazz),DaoUtil.INSERT);
        }else{
            return DaoUtil.messageString(clazzMapper.updateByPrimaryKey(clazz),DaoUtil.UPDATE);
        }
    }

    @Override
    public String deleteMany(int id[]) throws RuntimeException {
        for (int i=0;i<id.length;i++){
            deleteById(id[i]);
        }
        return DaoUtil.messageString(id.length,DaoUtil.DELETE);
    }


    @Override
    public List<ClazzEx> findAll() throws RuntimeException {
        List<ClazzEx> all = clazzExMapper.findAll();
        return all;
    }

    @Override
    public ClazzEx findById(int id) throws RuntimeException {
        return clazzExMapper.findById(id);
    }

    @Override
    public List<ClazzEx> findByCondi(String key, String word) throws RuntimeException {
        if((key==null||"".equals(key))&&(word==null||"".equals(word))){
            return clazzExMapper.findAll();
        }else if((key==null||"".equals(key))&&!"".equals(word)){
            word= word==null?"":word;
            word="%"+word+"%";
            return clazzExMapper.findByNameOrTeacher(word);
        }else if("name".equals(key)){
            word= word==null?"":word;
            word="%"+word+"%";
            return clazzExMapper.findByName(word);
        }else if ("teacher".equals(key)){
            word= word==null?"":word;
            word="%"+word+"%";
            return clazzExMapper.findByTeacher(word);
        }
        return null;
    }


}
