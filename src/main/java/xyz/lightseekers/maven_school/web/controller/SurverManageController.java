package xyz.lightseekers.maven_school.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lightseekers.maven_school.bean.Survey;
import xyz.lightseekers.maven_school.service.ISurverManageService;
import xyz.lightseekers.maven_school.util.Message;
import xyz.lightseekers.maven_school.util.MessageUtil;

@RestController
@RequestMapping("/surverManage")
@Api(description = "课调管理")
public class SurverManageController {

    @Autowired
    private ISurverManageService surverManageServiceey;

    @PostMapping("/add")
    @ApiOperation("新增课调")
    public Message add(Survey survey){
        return MessageUtil.success(surverManageServiceey.addOrUpdate(survey));
    }

    @PostMapping("/update")
    @ApiOperation("修改课调")
    public Message update(Survey survey){
        return MessageUtil.success(surverManageServiceey.addOrUpdate(survey));
    }

    @GetMapping("/deleteById")
    @ApiOperation("根据id删除课调")
    @ApiParam(required = true,name = "id",value = "课调id")
    public Message deleteById(int id){
        return MessageUtil.success(surverManageServiceey.deleteById(id));
    }

    @GetMapping("/deleteMany")
    @ApiOperation("批量删除")
    public Message deleteMany(int id[]){
        return MessageUtil.success(surverManageServiceey.deleteMany(id));
    }

    @GetMapping("/findAll")
    @ApiOperation("查询所有课调信息")
    public Message findAll(){
        return MessageUtil.success(surverManageServiceey.findAll());
    }

    @GetMapping("/findASurverById")
    @ApiOperation("根据id查找")
    @ApiParam(required = true,name = "id",value = "课调id")
    public Message findASurverById(int id){
        return MessageUtil.success(surverManageServiceey.findASurverById(id));
    }

    @GetMapping("/search")
    @ApiOperation("条件查询")
    public Message search(String word) {
        return MessageUtil.success(surverManageServiceey.search(word));
    }


}
