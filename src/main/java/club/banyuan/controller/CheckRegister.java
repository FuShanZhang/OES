package club.banyuan.controller;

/**
 * 校验器
 */
public class CheckRegister {

    //验证用户名(字母开头,允许5-16字节,允许字母数字下划线）
    public static boolean checkUserName(String username) {

        String regExp_userName = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$";

        if (username.matches(regExp_userName)) {
            return true;
        } else {
            return false;
        }
    }

    //正则表达式:验证密码(必须包含大小写字母和数字的组合，不能使用特殊字符，长度在 8-10 之间)
    public static boolean checkPwd(String pwd) {
        String regExp_pwd = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{8,10}$";
        if (pwd.matches(regExp_pwd)) {
            return true;
        } else {
            return false;
        }
    }

    //验证姓名(支持少数民族和生僻字,长度2-20之间,少数民族中间使用·)
    public static boolean checkName(String name) {
        String regExp_name = "^[\\u4E00-\\u9FA5\\uf900-\\ufa2d·s]{2,20}$";
        if (name.matches(regExp_name)) {
            return true;
        } else {
            return false;
        }
    }

    //验证学号(至少1位数字)
    public static boolean checkStuNum(String stuNum) {
        String regExp_stuNum = "^\\d+$";
        if (stuNum.matches(regExp_stuNum)) {
            return true;
        } else {
            return false;
        }
    }

    //验证手机号码(11位)
    public static boolean checkPhoneNum(String mpNum) {
        String regExp_mpNum = "^1[3456789]\\d{9}$";
        if (mpNum.matches(regExp_mpNum)) {
            return true;
        } else {
            return false;
        }
    }

    //验证邮箱
    public static boolean checkEmail(String email) {
        String regExp_email = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        if (email.matches(regExp_email)) {
            return true;
        } else {
            return false;
        }
    }
}
