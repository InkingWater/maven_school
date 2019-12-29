package xyz.lightseekers.maven_school.mapper.ex;

import org.springframework.stereotype.Repository;
import xyz.lightseekers.maven_school.bean.ex.RegionEX;

/**
 * @Author: ZhiliangJia
 * @Description:
 * @Date:Create in 10:55 2019/12/29
 * @Modified User:
 */
@Repository
public interface RegionEXMapper {
    RegionEX selectLast();
}
