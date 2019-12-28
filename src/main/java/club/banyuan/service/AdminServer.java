package club.banyuan.service;

public interface AdminServer {
     boolean insertUser(String name ,String password); //注册用户
     boolean usernameExist(String name); //查询用户姓名是否存在
     boolean login(String username,String password); //登陆核对用户名和密码

}
