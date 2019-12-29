package xyz.lightseekers.maven_school.service;

import xyz.lightseekers.maven_school.bean.Region;
import xyz.lightseekers.maven_school.bean.ex.RegionEX;

/**
 * @Author: ZhiliangJia
 * @Description:
 * @Date:Create in 10:11 2019/12/29
 * @Modified User:
 */
public interface IRegionService {
    RegionEX selectLast() throws RuntimeException;

    String insertOrUpdate(Region region) throws RuntimeException;

    String deleteById(int id);
}
