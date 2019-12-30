package xyz.lightseekers.maven_school.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lightseekers.maven_school.bean.Course;
import xyz.lightseekers.maven_school.service.impl.ICourseServiceImpl;
import xyz.lightseekers.maven_school.util.Message;
import xyz.lightseekers.maven_school.util.MessageUtil;

import java.util.List;

@RestController
@RequestMapping("/course")
@Api(description = "课程管理")
public class CourseController {

    /**
     * 获取Course的service
     */
    @Autowired
    private ICourseServiceImpl iCourseService;

    @GetMapping("/selectAll")
    @ApiOperation(value = "查找所有")
    public Message selectAll(){
        List<Course> list = iCourseService.findAll();
        return MessageUtil.success(list);
    }


    @GetMapping("/searchByCon")
    @ApiOperation(value = "根据名字或描述查找")
    public Message searchByCon(String key, String word){
        List<Course> list = iCourseService.search(key,word);
        return MessageUtil.success(list);
    }

    @GetMapping("/deleteById")
    @ApiOperation(value = "根据id删除")
    public Message deleteById(int id){
        iCourseService.deleteById(id);
        return MessageUtil.success("操作成功");
    }

    @PostMapping("/add")
    @ApiOperation(value = "插入")
    public Message add(Course course){
        iCourseService.insertOrUpdate(course);
        return MessageUtil.success(course);
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新")
    public Message update(Course course){
        iCourseService.insertOrUpdate(course);
        return MessageUtil.success(course);
    }

    @ApiOperation("批量删除")
    @GetMapping("/deleteBatch")
    public Message deleteBatch(int id[]){
        return MessageUtil.success(iCourseService.deleteBatch(id));
    }
}
