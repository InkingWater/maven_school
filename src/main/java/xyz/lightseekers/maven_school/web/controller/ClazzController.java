package xyz.lightseekers.maven_school.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lightseekers.maven_school.bean.Clazz;
import xyz.lightseekers.maven_school.service.IClazzService;
import xyz.lightseekers.maven_school.util.Message;
import xyz.lightseekers.maven_school.util.MessageUtil;

@RestController
@RequestMapping("clazz")
@Api(description = "班级管理")
public class ClazzController {

    @Autowired
    private IClazzService clazzService;

    @ApiOperation("查询所有班级")
    @GetMapping("/findAll")
    public Message findAll(){

        return MessageUtil.success(clazzService.findAll());
    }
    @ApiOperation("新增班级")
    @PostMapping("/add")
    public Message add(Clazz clazz){
        return MessageUtil.success(clazzService.addOrUpdate(clazz));
    }
    @ApiOperation("修改班级")
    @PostMapping("/update")
    public Message update(Clazz clazz){
        return MessageUtil.success(clazzService.addOrUpdate(clazz));
    }
    @ApiOperation("根据id删除班级")
    @GetMapping("/deleteById")
    public Message deleteById(int id){
        return MessageUtil.success(clazzService.deleteById(id));
    }
    @ApiOperation("批量删除")
    @GetMapping("/deleteMany")
    public Message deleteMany(int id[]){
        return MessageUtil.success(clazzService.deleteMany(id));
    }

    @GetMapping("/findById")
    @ApiOperation("根据id查找班级")
    public Message findById(int id){
        return MessageUtil.success(clazzService.findById(id));
    }

    @GetMapping("/search")
    @ApiOperation("条件搜索")
    public Message findByNameOrTeacher(String key,String word){
        return MessageUtil.success(clazzService.findByCondi(key,word));
    }
}
