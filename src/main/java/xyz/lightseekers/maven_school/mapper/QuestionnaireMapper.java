package xyz.lightseekers.maven_school.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import xyz.lightseekers.maven_school.bean.Questionnaire;
import xyz.lightseekers.maven_school.bean.QuestionnaireExample;

@Repository
public interface QuestionnaireMapper {
    long countByExample(QuestionnaireExample example);

    int deleteByExample(QuestionnaireExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Questionnaire record);

    int insertSelective(Questionnaire record);

    List<Questionnaire> selectByExampleWithBLOBs(QuestionnaireExample example);

    List<Questionnaire> selectByExample(QuestionnaireExample example);

    Questionnaire selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Questionnaire record, @Param("example") QuestionnaireExample example);

    int updateByExampleWithBLOBs(@Param("record") Questionnaire record, @Param("example") QuestionnaireExample example);

    int updateByExample(@Param("record") Questionnaire record, @Param("example") QuestionnaireExample example);

    int updateByPrimaryKeySelective(Questionnaire record);

    int updateByPrimaryKeyWithBLOBs(Questionnaire record);

    int updateByPrimaryKey(Questionnaire record);
}