package xyz.lightseekers.maven_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lightseekers.maven_school.bean.Region;
import xyz.lightseekers.maven_school.bean.ex.RegionEX;
import xyz.lightseekers.maven_school.mapper.RegionMapper;
import xyz.lightseekers.maven_school.mapper.ex.RegionEXMapper;
import xyz.lightseekers.maven_school.service.IRegionService;
import xyz.lightseekers.maven_school.util.DaoUtil;

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

    @Autowired
    private RegionMapper regionMapper;

    @Override
    public RegionEX selectLast() throws RuntimeException {
        return regionEXMapper.selectLast();
    }

    @Override
    public String insertOrUpdate(Region region) throws RuntimeException {
        if (region == null) {
            throw new RuntimeException("数据为空");
        }
        if (region.getId() != null) {
            return DaoUtil.messageString(regionMapper.updateByPrimaryKey(region),
                    DaoUtil.UPDATE);
        } else {
            return DaoUtil.messageString(regionMapper.insert(region),
                    DaoUtil.INSERT);
        }
    }

    @Override
    public String deleteById(int id) {
        return DaoUtil.messageString(regionMapper.deleteByPrimaryKey(id),
                DaoUtil.DELETE);
    }


}
