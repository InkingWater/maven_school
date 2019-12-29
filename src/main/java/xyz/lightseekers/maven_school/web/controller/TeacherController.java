package xyz.lightseekers.maven_school.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lightseekers.maven_school.bean.Teacher;
import xyz.lightseekers.maven_school.bean.ex.TeacherEX;
import xyz.lightseekers.maven_school.service.ITeacherService;
import xyz.lightseekers.maven_school.util.DaoUtil;
import xyz.lightseekers.maven_school.util.Message;
import xyz.lightseekers.maven_school.util.MessageUtil;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@Api(description = "教师管理")
public class TeacherController {
    @Autowired
    private ITeacherService iTeacherService;

    //添加数据
    @PostMapping("/addTeacher")
    @ApiOperation(value = "添加教师数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "教师ID", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "name", value = "教师姓名", paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "gender", value = "性别", paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "birthday", value = "出生日期", paramType = "query", dataType = "date-time"),
            @ApiImplicitParam(name = "startday", value = "入职时间", paramType = "query", dataType = "date-time"),
    })
    public Message addTeacher(Teacher teacher) {
        iTeacherService.saveOrUpdate(teacher);
        return MessageUtil.success(DaoUtil.INSERT);
    }


    //通过主键id查询数据
    @GetMapping("/selectById")
    @ApiOperation(value = "通过主键id查询教师数据")
    @ApiImplicitParam(name = "id", value = "教师ID", paramType = "query", dataType = "int")
    public Message selectById(int id) {
        Teacher teacher = iTeacherService.selectById(id);
        return MessageUtil.success(teacher);
    }


    //通过主键修改数据
    @PostMapping("/updateById")
    @ApiOperation(value = "通过主键修改数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "教师ID", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "name", value = "教师姓名", paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "gender", value = "性别", paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "birthday", value = "出生日期", paramType = "query", dataType = "date-time"),
            @ApiImplicitParam(name = "startday", value = "入职时间", paramType = "query", dataType = "date-time"),
    })
    public Message updateById(Teacher teacher) {
        iTeacherService.saveOrUpdate(teacher);
        return MessageUtil.success(DaoUtil.UPDATE);
    }


    //通过主键删除数据
    @GetMapping("/deleteById")
    @ApiOperation(value = "通过主键id删除教师数据")
    @ApiImplicitParam(name = "id", value = "教师ID", paramType = "query", dataType = "int")
    public Message deleteById(int id) {
        iTeacherService.deleteById(id);
        return MessageUtil.success(DaoUtil.DELETE);
    }


    //遍历全部数据
    @GetMapping("/selectAll")
    @ApiOperation(value = "遍历全部教师数据")
    public Message selectAll() {
        List<Teacher> list = iTeacherService.findAll();
        return MessageUtil.success(list);
    }

    //搜索框
    @GetMapping("/search")
    @ApiOperation(value = "搜索框")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "下拉栏", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "word", value = "输入框", paramType = "query", dataType = "String")
    })
    public Message search(String key, String word) {
        List<TeacherEX> list = iTeacherService.search(key, word);
        return MessageUtil.success(list);
    }

    //以数据组的形式进行多项删除
    @GetMapping("/deleteBatch")
    @ApiOperation(value = "多个删除")
    public Message deleteBatch(int ids[]) {
        for (int id : ids) {
            iTeacherService.deleteById(id);
        }
        return MessageUtil.success();
    }


//    //以String的形式进行多项删除
//    @GetMapping("/deleteBatch")
//    public Message deleteBatch(String ids) {
//        String[] id = ids.split(",");
//        for (String s : id) {
//            iTeacherService.deleteById(Integer.parseInt(s));
//        }
//        return MessageUtil.success();
//    }
}