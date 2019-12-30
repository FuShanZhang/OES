package club.banyuan.util;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 使用HikariCP连接池
 * 在resources文件夹下创建jdbc.properties     内容:password=你的mysql密码
 *
 * @author zhangfushan
 */
@SuppressWarnings("all")
public class HikariUtil {

    private static final HikariConfig hikariConfig = new HikariConfig();
    private static HikariDataSource dataSource;


    private HikariUtil() {
    }



    static {
        FileInputStream fileInputStream = null;
        try {
            String path = HikariUtil.class.getClassLoader().getResource("jdbc.properties").getPath();
            //fileInputStream = new FileInputStream("/db.properties");(问题,为什么这么写不行)
            fileInputStream = new FileInputStream(path);
            Properties pro = new Properties();
            pro.load(fileInputStream);

            hikariConfig.setJdbcUrl("jdbc:mysql:///oes?useSSL=false");
            hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
            hikariConfig.setUsername("root");
            hikariConfig.setPassword(pro.getProperty("password"));


            //todo:此配置可进行后期调优
            hikariConfig.addDataSourceProperty("cachePrepStmts", "true");//是否自定义配置，开启后后面语句有效
            hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");//连接池大小默认25，官方推荐250-500
            hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");//单条语句最大长度默认256，官方推荐2048
            hikariConfig.addDataSourceProperty("useServerPrepStmts", "true");//新版mysql支持的服务器端准备,开启后提升性能

            dataSource = new HikariDataSource(hikariConfig);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //获取连接
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }


    //释放连接
    public static void release(ResultSet rs , Statement stat , Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stat != null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
