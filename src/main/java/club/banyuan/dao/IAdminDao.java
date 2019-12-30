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
    void insertUser(String username,String password);//增加学员1
    boolean usernameExit(String username);//2根据传过来的username，判断在数据库中是否存在，如果存在返回true，否则返回false
    String getPasswordByUsername(String username);//3、根据用户名获取用户密码
    void delStudent(String username);//删除考试学员
    void updateStudent(String username,String password,int id);//修改考试学员
    List<Student> selectStudentByName(String username);//通过姓名查询学生信息
    void insertQuestion(Question question);//增加考题
    void delQuestion(Integer id);//删除考题
    void updateQuestion(Integer id,String opt);//修改考题
    List<Question> selectQuestionByID(Integer id);//根据id查询试题信息

}
