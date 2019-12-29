package xyz.lightseekers.maven_school.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
@Api(description = "学校控制器类")
public class RegionController {
    @Autowired
    private IRegionService regionService;

    @GetMapping(value = "selectLast")
    @ApiOperation(value = "查找最新添加的一个数据")
    public Message selectLast() {
        return MessageUtil.success(regionService.selectLast());
    }
}
