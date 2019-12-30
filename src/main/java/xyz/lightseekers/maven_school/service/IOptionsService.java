package xyz.lightseekers.maven_school.service;

import xyz.lightseekers.maven_school.bean.Options;

public interface IOptionsService {
    //插入一条数据
    void addOptions(Options options)throws RuntimeException;
}
