package xyz.lightseekers.maven_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lightseekers.maven_school.bean.Teacher;
import xyz.lightseekers.maven_school.bean.TeacherExample;
import xyz.lightseekers.maven_school.bean.ex.TeacherEX;
import xyz.lightseekers.maven_school.mapper.TeacherMapper;
import xyz.lightseekers.maven_school.mapper.ex.TeacherEXMapper;
import xyz.lightseekers.maven_school.service.ITeacherService;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private TeacherEXMapper teacherEXMapper;

    //添加或者修改
    @Override
    public void saveOrUpdate(Teacher teacher) throws RuntimeException {
        //如果传入的参数是空值，则抛出一个异常
        if (teacher == null) {
            throw new RuntimeException();
        }
        //如果传入的参数没有ID，则添加数据
        else if (teacher.getId() == null) {
            teacherMapper.insert(teacher);
        }
        //如果传入的参数有ID，则根据主键ID修改数据
        else {
            teacherMapper.updateByPrimaryKey(teacher);
        }
    }

    //通过主键查找
    @Override
    public Teacher selectById(int id) throws RuntimeException {
        return teacherMapper.selectByPrimaryKey(id);
    }

    //通过主键删除
    @Override
    public void deleteById(int id) throws RuntimeException {
        teacherMapper.deleteByPrimaryKey(id);
    }

    //遍历数据
    @Override
    public List<Teacher> findAll() throws RuntimeException {
        TeacherExample teacherExample = new TeacherExample();
        List<Teacher> list = teacherMapper.selectByExample(teacherExample);
        return list;
    }

    //搜索栏----------下拉栏key只设置了gender性别，word只有男or女两个值
    @Override
    public List<TeacherEX> search(String key, String word) throws RuntimeException {
        //下拉栏为空，输入框为空
        if ((key == null || "".equals(key)) && (word == null || "".equals(word))) {
            return teacherEXMapper.selectAll();
        }
        //下拉栏为空，输入框不为空
        else if ((key == null || "".equals(key)) && (!"".equals(word))) {
            //模糊查询，%为通配符，代表任意数量的字符
            word = "%" + word + "%";
            return teacherEXMapper.selectByGender(word);
        } else if("gender".equals(key)){
            if (word == null || "".equals(word)){
                return teacherEXMapper.selectAll();
            }
            else{
                word = "%" + word + "%";
                return  teacherEXMapper.selectGender(word);
            }
        }
        else {
            return null;
        }
    }
}
