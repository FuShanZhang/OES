package club.banyuan.service.Impl;

import club.banyuan.dao.AdminDaoImpl;
import club.banyuan.dao.IAdminDao;
import club.banyuan.service.AdminServer;
/*

*/

/**
 *   功能：（1）增加新用户  （2）判断用户名密码是否匹配 (3)判断用户是否存在
 *   方法：insertUser()，增加新用户，查看数据库中是否有用户，如果有，返回false，如果没有进行插入操作。
 *        login(),判断用户名密码是否匹配；如果登陆用户名不再数据中，则返回false，如果在，核对传过来的密码是否与数据中密码相同；
 *        如果相同，返回true，否则返回false。
 *   ----
 *   @author 翁
 */



public class AdminServerImpl implements AdminServer{
    private IAdminDao adminDaologin;

    public boolean usernameExist(String name) {
        adminDaologin=new AdminDaoImpl();
        return adminDaologin.usernameExit(name);
    }

    public boolean insertUser(String username, String password) {//新用户插入
        adminDaologin =new AdminDaoImpl();
        //判断用户是否在数据库中存在
        if(usernameExist(username)){
            //如果存在返回false；
            return false;
        }else {
            //否则将用户账户和密码插入并返回true
            adminDaologin.insertUser(username,password);
            return true;
        }
    }

    public boolean login(String username, String password) {
        //新建dao层接口实例对象
        adminDaologin=new AdminDaoImpl();
        if(usernameExist(username)){
            String pwd = adminDaologin.getPasswordByUsername(username);
            return pwd.equals(password);
        }
        return false;
        //判断用户是否存在，如果存在，进行下一步
        /*usernameExist(username*/
        //判断用户的账户密码是否相同，业务逻辑上不允许用户名重复
        //如果登陆密码与数据库中存储的密码相同，则返回true，否则返回false；
    }








}

