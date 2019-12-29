package xyz.lightseekers.maven_school.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import xyz.lightseekers.maven_school.bean.Survey;
import xyz.lightseekers.maven_school.bean.SurveyExample;

@Repository
public interface SurveyMapper {
    long countByExample(SurveyExample example);

    int deleteByExample(SurveyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Survey record);

    int insertSelective(Survey record);

    List<Survey> selectByExample(SurveyExample example);

    Survey selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Survey record, @Param("example") SurveyExample example);

    int updateByExample(@Param("record") Survey record, @Param("example") SurveyExample example);

    int updateByPrimaryKeySelective(Survey record);

    int updateByPrimaryKey(Survey record);
}