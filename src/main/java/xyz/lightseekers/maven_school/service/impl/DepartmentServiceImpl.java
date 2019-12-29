package xyz.lightseekers.maven_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.lightseekers.maven_school.bean.Department;
import xyz.lightseekers.maven_school.bean.ex.DepartmentEX;
import xyz.lightseekers.maven_school.mapper.DepartmentMapper;
import xyz.lightseekers.maven_school.mapper.ex.DepartmentEXMapper;
import xyz.lightseekers.maven_school.service.IDepartmentService;

import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private DepartmentEXMapper departmentEXMapper;

    @Override
    public List<DepartmentEX> findAllDepartmentEX() throws RuntimeException {
        List<DepartmentEX> list=departmentEXMapper.findAll();
        return list;
    }


    @Override
    public List<DepartmentEX> finder(String key, String word) throws RuntimeException {
        if ((key==null||"".equals(key))&&(word==null||"".equals(word))) {
            return findAllDepartmentEX();
        }else if((key==null||"".equals(key))&&!"".equals(word))
        {//前者为空 后者不为空
            word="%"+word+"%";
            return  departmentEXMapper.selectnameOrdep(word);
        }else if("name".equals(key))
        {
            word="%"+word+"%";
            return   departmentEXMapper.selectname(word);
        }else if("dep".equals(key))
        {
            word="%"+word+"%";
            return  departmentEXMapper.selectdep(word);
        }
        return null;
    }

    @Override
    public void saveOrUpdate(Department department) throws RuntimeException {
        if(department==null)
        {
            throw new RuntimeException("参数为空");
        }if(department.getId()==null)
        {
            departmentMapper.insert(department);
        }else{
            departmentMapper.updateByPrimaryKey(department);
        }

    }

    @Override
    public void deleteById(int id) throws RuntimeException {
        departmentMapper.deleteByPrimaryKey(id);
    }
}

