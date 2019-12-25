package club.banyuan.util;



import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 使用HikariCP连接池
 * 在resources中创建jdbc.properties     内容:password=你的mysql密码
 * @author zhangfushan
 */
@SuppressWarnings("all")
public class HikariUtil {

    private static Connection conn ;


    public static Connection getConnection(){
        FileInputStream fileInputStream = null;
        Properties pro ;
        try {
            String path = HikariUtil.class.getClassLoader().getResource("jdbc.properties").getPath();
            fileInputStream  = new FileInputStream(path);
            pro =  new Properties();
            pro.load(fileInputStream);

            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setJdbcUrl("jdbc:mysql:///oes?useSSL=false");
            hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
            hikariConfig.setUsername("root");
            hikariConfig.setPassword(pro.getProperty("password"));

            hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
            hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
            hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
            HikariDataSource ds = new HikariDataSource(hikariConfig);
            try {
                conn = ds.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
        return conn;
    }

}
