package club.banyuan.dao;

import club.banyuan.pojo.Question;

import java.util.List;

/**
 * 题目接口：
 *      功能：以传入subject分组查出所有的该科目题目。
 */
public interface IQuestion {
    List<Question> selectAllQuestionBySubject();
}
