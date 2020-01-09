package club.banyuan.dao;

import club.banyuan.pojo.Question;
import club.banyuan.util.HikariUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description 试题层，查询试题信息
 *  @author zhangyuting
 * @author weng
 */
public class QuestionDaoImpl implements IQuestionDao {


    @Override
    public List<Question> selectSubject(String subjectName , Integer qType)  {
        //获取连接
        Connection con = HikariUtil.getConnection();
        //新建集合
        ArrayList<Question> list = new ArrayList<Question>();
        //通过传过来的科目名称选择题目
        String sql = "select * from question where qsubject=? and qtype = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, subjectName);
            ps.setInt(2,qType);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt(1));
                question.setName(rs.getString(2));
                question.setOpt(rs.getInt(3));
                question.setSubject(rs.getString(4));
                question.setQuestionText(rs.getString(5));
                question.setQuestionType(rs.getInt(6));
                list.add(question);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Question> selectAllQuestion()  {
        //获取连接
        Connection con = HikariUtil.getConnection();
        //新建集合
        ArrayList<Question> list = new ArrayList<Question>();
        //通过传过来的科目名称选择题目
        String sql = "select * from question";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt(1));
                question.setName(rs.getString(2));
                question.setOpt(rs.getInt(3));
                question.setSubject(rs.getString(4));
                question.setQuestionText(rs.getString(5));
                question.setQuestionType(rs.getInt(6));
                list.add(question);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }



    //增加科目
    public void addSb(int id,String subject){
        Connection con = HikariUtil.getConnection();
        String sql = "insert into subject(sb_id,sb_name) values(?,?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.setString(2,subject);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //判断该题目id是否存在，如果存在返回true，否则返回false
    //查询操作
    @Override
    public boolean idExist(int id) {
        Connection con = HikariUtil.getConnection();
        String sql = "select qid from question where qid=?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet re = stmt.executeQuery();
            return re.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //通过传回的id在数据库中获取对应的答案，并返回.表question的qopt就是答案，qquestion_text包括了题目和选项
    @Override
    public String getAnswerById(int id) {
        Connection con = HikariUtil.getConnection();
        String sql = "select qopt from question where qid = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet re = stmt.executeQuery();
            while(re.next()){
                System.out.println(re.getString("qopt"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //判断填入的答案是否与数据库中标准答案相同
    //查询数据库中的标准答案
    @Override
    public boolean CompareAnswer(String answer) {
        Connection con = HikariUtil.getConnection();
        String sql = "select qopt from question where qopt = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,answer);
            ResultSet re = stmt.executeQuery();
            return re.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }
}