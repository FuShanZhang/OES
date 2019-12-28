package club.banyuan.dao;
/**
 * @description 试题层，查询试题信息
 * @author zhangyuting
 * */
import club.banyuan.pojo.Question;
import club.banyuan.util.HikariUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuestionDaoImpl implements IQuestionDao {

    //通过科目查询该科目相关的所有试题,单表查询
    @Override
    public List<Question> selectAllQuestionBySubject( String subject) {
        List<Question> list = new ArrayList<Question>();
        Connection con = HikariUtil.getConnection();
        String  sql = " select * from question where question.qsubject =? ";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,subject);
            ResultSet re = stmt.executeQuery();
            while(re.next()){
                Question question = new Question();
                question.setId(re.getInt("qid"));
                question.setName(re.getString("qname"));
                question.setOpt(re.getInt("qopt"));
                question.setQuestionText(re.getString("qquestion_text"));
                question.setSubject(re.getString("qsubject"));
                question.setQuestionType(re.getInt("qtype"));
                list.add(question);
            }
        } catch (SQLException e) {
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
