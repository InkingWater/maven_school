package xyz.lightseekers.maven_school.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lightseekers.maven_school.bean.Department;
import xyz.lightseekers.maven_school.bean.ex.DepartmentEX;
import xyz.lightseekers.maven_school.service.IDepartmentService;
import xyz.lightseekers.maven_school.util.Message;
import xyz.lightseekers.maven_school.util.MessageUtil;

import java.util.List;

@RestController
@RequestMapping("/department")
@Api(description="年级管理控制器")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

    @GetMapping("/selectAll")
    @ApiOperation("查找全部信息")
    public Message selectAll()
    {
        List<DepartmentEX> list=departmentService.findAllDepartmentEX();
        return MessageUtil.success(list);
    }

    @GetMapping("/selectBy")
    public Message selectBy(String key,String word)
    {
        List<DepartmentEX> list = departmentService.finder(key,word);
        return MessageUtil.success(list);
    }

    @PostMapping("/add")
    public Message add(Department department)
    {
         departmentService.saveOrUpdate(department);
        return MessageUtil.success();
    }


    @GetMapping("/delete")
    @ApiOperation("通过id删除信息")
    public Message del(int id)
    {
        departmentService.deleteById(id);
        return MessageUtil.success();
    }


}
