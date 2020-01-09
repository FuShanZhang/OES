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

    public boolean usernameExistR(String name){
        adminDaologin = new AdminDaoImpl();
        return adminDaologin.usernameExitR(name);
    }

    public boolean insertUser(String username,String name, String password) {//新用户插入
        adminDaologin =new AdminDaoImpl();
        //判断用户是否在数据库中存在
        if(usernameExist(username)){
            //如果存在返回false；
            return false;
        }else {
            //否则将用户账户和密码插入并返回true
            adminDaologin.insertUser(username,name,password);
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

    /*管理员登陆*/
    public boolean loginR(String username, String password) {
        //新建dao层接口实例对象
        adminDaologin=new AdminDaoImpl();
        if(usernameExistR(username)){
            String pwd = adminDaologin.getPasswordByUsernameR(username);
            return pwd.equals(password);
        }
        return false;
        //判断用户是否存在，如果存在，进行下一步
        /*usernameExist(username*/
        //判断用户的账户密码是否相同，业务逻辑上不允许用户名重复
        //如果登陆密码与数据库中存储的密码相同，则返回true，否则返回false；
    }

    public String parseOpt(Integer opt){
        if(opt.equals(1)){
            return "A";
        }else if(opt.equals(10)){
            return "B";
        }else if(opt.equals(100)){
            return "C";
        }else if(opt.equals(1000)){
            return "D";
        }else if(opt.equals(1111)){
            return "ABCD";
        }else if(opt.equals(1110)){
            return "ABC";
        }else if(opt.equals(111)){
            return "BCD";
        }else if(opt.equals(1101)){
            return "ABD";
        }else if(opt.equals(1011)){
            return "ACD";
        }else if(opt.equals(1100)){
            return "AB";
        }else if(opt.equals(1010)){
            return "AC";
        }else if(opt.equals(1001)){
            return "AD";
        }else if(opt.equals(110)){
            return "BC";
        }else if(opt.equals(101)){
            return "BD";
        }else {
            return "CD";
        }
    }

    public Integer parseOptToInt(String opt){
        Integer sum = 0;
        if(opt.contains("A")){
            sum+=1;
        }
        if(opt.contains("B")){
            sum+=10;
        }
        if(opt.contains("C")){
            sum+=100;
        }
        if(opt.contains("D")){
            sum+=1000;
        }
        return sum;
    }







}

