package xyz.lightseekers.maven_school.mapper.ex;

import org.springframework.stereotype.Repository;
import xyz.lightseekers.maven_school.bean.ex.TeacherEX;

import java.util.List;

@Repository
public interface TeacherEXMapper {
    //搜索栏 空+不空
    List<TeacherEX> selectByGender(String word) throws RuntimeException;

    /**
     * 搜索栏通过下拉栏来进行搜索，只有一个gender的值
     * @param word
     * @return
     * @throws RuntimeException
     */
    List<TeacherEX> selectGender(String word) throws RuntimeException;
    //搜索栏 空+空
    List<TeacherEX> selectAll() throws RuntimeException;
}