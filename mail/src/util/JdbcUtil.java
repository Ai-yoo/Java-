package util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {
    private static String dirverName;
    private static String url;
    private static String username;
    private static String password;

    //    利用静态块i，在类加载的时候就被执行
    static {
        try {
//            用流读入properties配置文件
            InputStream inputStream = JdbcUtil.class.getClassLoader()
                    .getResourceAsStream("datebase.properties");
            Properties properties = new Properties();
//            从输入字节流读取属性列表（键和元素对）
            properties.load(inputStream);
//            用此属性列表中指定的键搜索属性，获取驱动，url，username，password
            dirverName = properties.getProperty("driverName").trim();
            url = properties.getProperty("url").trim();
            username = properties.getProperty("username").trim();
            password = properties.getProperty("password").trim();
            System.out.println(dirverName);
            System.out.println(url);
            System.out.println(username);
            System.out.println(password);
//            加载驱动
            Class.forName(dirverName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

//    获取数据库连接
    public static Connection getConnection() {
        Connection conn=null;
        try {
            conn=DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

//测试
//    public static void main(String[] args) {
//       JdbcUtil.getConnection();
//    }
//关闭连接工具方法
    public static void releaseResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            connection.close();
            preparedStatement.close();
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
