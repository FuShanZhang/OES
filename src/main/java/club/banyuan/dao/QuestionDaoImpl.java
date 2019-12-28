package club.banyuan.dao;
import club.banyuan.pojo.Question;
import club.banyuan.util.HikariUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDaoImpl implements IQuestionDao {
    PreparedStatement ps;
    Connection con;
    ResultSet rs;

    @Override
    public List<Question> selectSubject(String subjectName) {
        //获取连接
        con = HikariUtil.getConnection();
        //新建集合
        List<Question> list = new ArrayList();
        //通过传过来的科目名称选择题目
        String sql = "select * from question where qsubject=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, subjectName);
            rs = ps.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt(1));
                question.setName(rs.getString(2));
                question.setOpt(rs.getInt(3));
                question.setSubject(rs.getString(4));
                question.setQuestionText(rs.getString(5));
                question.setType(rs.getInt(6));
                list.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
}
