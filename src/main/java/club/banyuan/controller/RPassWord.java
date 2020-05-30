package club.banyuan.controller;


import java.io.*;
import java.util.Properties;

/**
 * 记住密码功能
 */

public class RPassWord {
    private static Properties pro;
    private static File file = new File("user.properties");


    //存储
    public static void rp(String userName, String password) {
        // File file = new File("user.txt");
        if (file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        try {
            pro = new Properties();
            FileOutputStream fos = new FileOutputStream(file);
            pro.put(userName, password);
            pro.store(fos, "users information");
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //读取
    public static void read() {
        try {
            pro = new Properties();
            FileInputStream fis = new FileInputStream(file);
            pro.load(fis);
//            Iterator<String> it = pro.stringPropertyNames().iterator();
//            while (it.hasNext()) {
//                String userName= it.next();
//                System.out.println(userName+ ":" + pro.getProperty(userName));
//            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
