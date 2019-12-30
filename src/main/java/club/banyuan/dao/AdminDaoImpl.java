package club.banyuan.dao;

import club.banyuan.pojo.Question;
import club.banyuan.pojo.Student;
import club.banyuan.util.HikariUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * 对Student表进行增删改查操作
 * @author zhangyuting
 * */
public class AdminDaoImpl implements IAdminDao{


    @Override
    //1、在Student表格里面增加学员 insert into student(username,password)values(susername,spassword)
    public  void insertUser(String username, String password) {
        Connection cnn = HikariUtil.getConnection();//连接到数据库
        String sql = "insert into student(susername,spassword)values(?,?)";
        try {
            PreparedStatement stmt=cnn.prepareStatement(sql);//在执行SQL语句之前，先创建一个statement对象
            stmt.setString(1,username);//此处“1”表示第一个“？”，表示第一个宿主变量username
            stmt.setString(2,password);//此处“2”表示第二个“？”，表示第二个宿主变量password
            stmt.executeUpdate();//返回受SQL语句影响的行数，  除了执行查询select语句时用executeQuery,其他的诸如insert/update/delete/等语句都可以用executeUpdate.另外还有一个execute可以执行任意SQL语句
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //2根据传过来的username，判断在数据库中是否存在该用户，如果存在返回true，否则返回false
    //    //查询操作，根据用户名查询用户信息
    @Override
    public boolean usernameExit(String username) {
        Connection con = HikariUtil.getConnection();//连接到数据库
        String sql = "select * from student where susername = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,username);
            ResultSet re = stmt.executeQuery();
            return re.next();//这边如果查询到了该用户则返回ture,如果没有查询到就返回false
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;//这边false的意义在于：如果上面sql语句写错了，则会被catch捕捉到异常，try里面语句不会吧执行，就会返回false
    }

    //3、根据用户名获取用户密码
    //查询用户密码，根据用户名查询用户密码
    @Override
    public String getPasswordByUsername(String username) {
       Connection con = HikariUtil.getConnection();
       String sql = "select spassword from student where susername = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,username);
            ResultSet re = stmt.executeQuery();//查询返回一个结果集
            re.next();
            return re.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //删除考试学员
    @Override
    public void delStudent(String  username) {
        Connection con = HikariUtil.getConnection();
        String sql = "delete from student where susername = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,username);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //修改学员
    @Override
    public void updateStudent(String username,String password,int id) {
        Connection con = HikariUtil.getConnection();
        String sql = "update student set susername = ?,spassword = ? where sid = ?";//id是主键，不能随意更改，只能更改姓名和密码
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,username);
            stmt.setString(2,password);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //通过姓名查询学生信息
    @Override
    public List<Student> selectStudentByName(String username) {
        List<Student> list = new ArrayList<Student>();
        Connection con = HikariUtil.getConnection();
        String sql = "select * from student where susername = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,username);
            ResultSet re = stmt.executeQuery();
            //把数据从结果集取出来放入list集合
            while(re.next()){
                Student student = new Student();
                student.setId(re.getInt("id"));
                student.setUsername(re.getString("username"));
                student.setPassword(re.getString("password"));
                list.add(student);//将student对象放入集合中
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
    //增加考题
    @Override
    public void insertQuestion(Question question) {
        Connection con = HikariUtil.getConnection();
        String sql = "insert into question(qname,qopt,qsubject,qquestion_text,qtype) values(?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,question.getName());
            stmt.setInt(2,question.getOpt());
            stmt.setString(3,question.getSubject());
            stmt.setString(4,question.getQuestionText());
            stmt.setInt(5,question.getQuestionType());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            HikariUtil.release(null,stmt,con);
        }

    }

    //删除考题
    @Override
    public void delQuestion(Integer id) {
        Connection con = HikariUtil.getConnection();
        String sql = "delete from question where qid = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //修改考题,此处我是根据id修改题目的答案
    @Override
    public void updateQuestion(Integer id,String opt) {
        Connection con = HikariUtil.getConnection();
        String sql = "update question set qopt = ? where qid = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,opt);
            stmt.setInt(2,id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //根据id查询试题信息
    @Override
    public List<Question> selectQuestionByID(Integer id) {
        Connection con = HikariUtil.getConnection();
        String sql = "select * from question where qid = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet re = stmt.executeQuery();
            while (re.next()){
                System.out.println("qid="+re.getString(1)+",qname="+re.getString(2)+",qopt="+re.getString(3)+",qsubject="+re.getString(4)+",qquestion_text="+re.getString(5)+",qtype="+re.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
