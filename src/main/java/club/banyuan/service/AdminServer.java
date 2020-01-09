package club.banyuan.service;

public interface AdminServer {
     public boolean insertUser(String username,String name, String password);
     boolean usernameExist(String name); //查询用户姓名是否存在
     boolean login(String username,String password); //登陆核对用户名和密码
     public boolean loginR(String username, String password);

}
