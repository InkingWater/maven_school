package xyz.lightseekers.maven_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lightseekers.maven_school.bean.Course;
import xyz.lightseekers.maven_school.bean.CourseExample;
import xyz.lightseekers.maven_school.bean.Region;
import xyz.lightseekers.maven_school.mapper.CourseMapper;
import xyz.lightseekers.maven_school.mapper.ex.CourseMapperEX;
import xyz.lightseekers.maven_school.service.ICourseService;
import xyz.lightseekers.maven_school.util.DaoUtil;

import java.util.List;


@Service
public class ICourseServiceImpl implements ICourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseMapperEX courseMapperEX;

    @Override
    public List<Course> findAll() throws RuntimeException {

        CourseExample courseExample = new CourseExample();
        List<Course> courses =  courseMapper.selectByExample(courseExample);
        return courses;
    }

    @Override
    public List<Course> search(String key, String word) throws RuntimeException {
        if (key == null || "".equals((key)) && (word == null) || "".equals(word)) {
            return findAll();
        }else if(key == null || "".equals((key)) && !"".equals(word)){
            List<Course> list0 =  courseMapperEX.selectNameOrDescription(word);
            return list0 ;
        }else if ("name".equals(key)) {
                return courseMapperEX.selectName(word);

            // 下拉框选择了description就根据description查询
        } else if("description".equals(key)) {
            return  courseMapperEX.selectDescription(word);
        }


        return null;
    }

    @Override
    public String insertOrUpdate(Course course) throws RuntimeException {
        if (course == null) {
            throw new RuntimeException();
        }
        if (course.getId() == null) {
            return DaoUtil.messageString(courseMapper.updateByPrimaryKey(course),
                    DaoUtil.UPDATE);
        } else {
            return DaoUtil.messageString(courseMapper.insert(course),
                    DaoUtil.INSERT);
        }
    }

    @Override
    public String deleteById(int id) {
        return DaoUtil.messageString(courseMapper.deleteByPrimaryKey(id),
                DaoUtil.DELETE);
    }
}

