package xyz.lightseekers.maven_school.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lightseekers.maven_school.bean.Region;
import xyz.lightseekers.maven_school.mapper.ex.RegionEXMapper;
import xyz.lightseekers.maven_school.service.IRegionService;
import xyz.lightseekers.maven_school.util.Message;
import xyz.lightseekers.maven_school.util.MessageUtil;

/**
 * @Author: ZhiliangJia
 * @Description:
 * @Date:Create in 11:11 2019/12/29
 * @Modified User:
 */
@RestController
@RequestMapping(value = "region")
@Api(description = "学校管理")
public class RegionController {
    @Autowired
    @Qualifier(value = "regionService")
    private IRegionService regionService;

    @GetMapping(value = "selectLast")
    @ApiOperation(value = "查找最新添加的一个数据")
    public Message selectLast() {
        return MessageUtil.success(regionService.selectLast());
    }

    @PostMapping(value = "insert")
    @ApiOperation(value = "添加一条学生数据")
    public Message insert(Region region) {
        return MessageUtil.success(regionService.insertOrUpdate(region));
    }

    @PostMapping(value = "updateById")
    @ApiOperation(value = "通过Id更新学生数据")
    public Message updateById(Region region) {
        return MessageUtil.success(regionService.insertOrUpdate(region));
    }

    @GetMapping(value = "deleteById")
    @ApiOperation(value = "通过Id删除学生数据")
    @ApiImplicitParam(name = "id", value = "学校编号", paramType = "query", dataType = "int",required = true)
    public Message deleteById(int id) {
        return MessageUtil.success(regionService.deleteById(id));
    }
}
