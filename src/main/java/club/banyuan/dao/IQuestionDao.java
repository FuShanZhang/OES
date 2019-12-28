package club.banyuan.dao;


import club.banyuan.pojo.Question;
import java.util.List;

/**
 * 题目接口：
 *      功能：以传入subject分组查出所有的该科目题目。
 */

public interface IQuestionDao {

    public List selectSubject(String subjectName);

    List<Question> selectAllQuestionBySubject(String subject);//通过科目查询该科目相关的所有试题信息
    boolean idExist(int id);//判断该题目id是否存在，如果存在返回true，否则返回false
    String getAnswerById(int id);//通过传回的id在数据库中获取对应的答案，并返回.表question的qopt就是答案，qquestion_text包括了题目和选项
     boolean CompareAnswer(String answer);//判断填入的答案是否与数据库中标准答案相同



}
