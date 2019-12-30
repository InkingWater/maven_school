package xyz.lightseekers.maven_school.mapper.ex;

import org.springframework.stereotype.Repository;
import xyz.lightseekers.maven_school.bean.Question;
import xyz.lightseekers.maven_school.bean.ex.QuestionEX;

import java.util.List;

/**
 * @Author: ZhiliangJia
 * @Description:
 * @Date:Create in 20:52 2019/12/29
 * @Modified User:
 */
@Repository
public interface QuestionEXMapper {
    QuestionEX selectById(int id) throws RuntimeException;
    //搜索栏
    List<QuestionEX> selectByName(String word)throws RuntimeException;
    //添加全部查找方法
    List<QuestionEX> selectAll() throws RuntimeException;
    //添加数据
    QuestionEX insertOne(QuestionEX questionEX)throws RuntimeException;
}
