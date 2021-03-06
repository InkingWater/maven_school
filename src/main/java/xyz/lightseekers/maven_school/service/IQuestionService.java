package xyz.lightseekers.maven_school.service;

import xyz.lightseekers.maven_school.bean.Options;
import xyz.lightseekers.maven_school.bean.Question;
import xyz.lightseekers.maven_school.bean.ex.QuestionEX;

import java.util.List;

/**
 * @Author: ZhiliangJia
 * @Description:
 * @Date:Create in 21:01 2019/12/29
 * @Modified User:
 */
public interface IQuestionService {
    //查询某一条题目数据
    QuestionEX selectById(int id);

    //单个删除---删除选项
    void deleteOptionsById(int id) throws RuntimeException;
    //根据主键修改选项

    //查询全部数据
    List<QuestionEX> selectAll() throws RuntimeException;

    //对题目表插入一条数据
    void insertQuestion(Question question, List<Options> list) throws RuntimeException;

    //级联删除----删除题目
    void deleteById(int id) throws RuntimeException;

    //修改题目
    void updateById(Question question) throws RuntimeException;

    //未实现或无法实现
//    //【未实现】修改题目+修改选项+修改
//    void updateQuestionPlus(Question question,List<Options> options)throws RuntimeException;
    //    //搜索栏
//    List<QuestionEX> search(String word)throws RuntimeException;
}
