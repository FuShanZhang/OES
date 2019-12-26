package club.banyuan.dao;

import club.banyuan.pojo.Question;
import club.banyuan.pojo.Student;

import java.util.List;

/**
 * 管理员dao层接口，功能模块：
 *      B1增加考试学员（必做）
 *      B2删除考试学员（必做）
 *      B3修改考试学员（必做）
 *      B4查询考试学员（必做）
 *      B5增加考题(选做)
 *      B6修改考题(选做)
 *      B7删除考题(选做)
 *      B8查询考题 按照id 或者 查询所有的(选做)
 *      B9批量导入考题(选做)，这个是批量处理
 * @author zhangyuting
 */
public interface IAdminDao {
    void insertUser(String username,String password);//增加学员
    void insertQuestion();//增加考题
    void delStudent();//删除考试学员
    void delQuestion();//删除考题
    void updateStudent();//修改考试学员
    void updateQuestion();//修改考题
    boolean usernameExit(String username);//根据传过来的username，判断在数据库中是否存在，如果存在返回true，否则返回false
    String getPasswordByUsername(String username);
    List<Student> selectStudentByName();
    List<Question> selectQuestionByID();

}
