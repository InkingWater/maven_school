package xyz.lightseekers.maven_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lightseekers.maven_school.bean.ex.RegionEX;
import xyz.lightseekers.maven_school.mapper.ex.RegionEXMapper;
import xyz.lightseekers.maven_school.service.IRegionService;

/**
 * @Author: ZhiliangJia
 * @Description:
 * @Date:Create in 10:12 2019/12/29
 * @Modified User:
 */
@Service
public class RegionServiceImpl implements IRegionService {

    @Autowired
    private RegionEXMapper regionEXMapper;

    @Override
    public RegionEX selectLast() {
        return regionEXMapper.selectLast();
    }
}
