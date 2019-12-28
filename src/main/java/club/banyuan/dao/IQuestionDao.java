package club.banyuan.dao;

import java.util.List;

/**
 * 题目接口：
 *      功能：以传入subject分组查出所有的该科目题目。
 */
public interface IQuestionDao {
    public List selectSubject(String subjectName);

}
