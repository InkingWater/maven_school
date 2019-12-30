package xyz.lightseekers.maven_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lightseekers.maven_school.bean.Options;
import xyz.lightseekers.maven_school.mapper.OptionsMapper;
import xyz.lightseekers.maven_school.service.IOptionsService;
@Service
public class OptionsServiceImpl implements IOptionsService {
    @Autowired
    private OptionsMapper optionsMapper;

    @Override
    public void updateOption(Options options) throws RuntimeException {
        optionsMapper.updateByPrimaryKey(options);
    }
}
