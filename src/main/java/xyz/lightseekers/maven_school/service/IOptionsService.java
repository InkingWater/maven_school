package xyz.lightseekers.maven_school.service;

import xyz.lightseekers.maven_school.bean.Options;

public interface IOptionsService {
    /**
     * 修改一条数据
     * @param options
     * @throws RuntimeException
     */
    void updateOption(Options options) throws RuntimeException;
}
