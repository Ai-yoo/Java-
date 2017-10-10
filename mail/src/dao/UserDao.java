package dao;

import domain.User;
import util.ConnectionManager;
import util.EncodeMD5;
import util.Time;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

public class UserDao {
    public void add(User user) {
       Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps=null;
        String sql = "insert into user values(default,?,?,1,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRandomcode());
            ps.setObject(4, user.getDate());
            ps.setString(5, user.getEmail());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(String name) {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = null;
        String sql = "update user set flag=0 where name=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void delete(String name) {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = null;
        String sql = "delete from user where name=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean login(String username, String password) {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql="select * from user where name=? and password=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                int flag=rs.getInt(4);
                if (flag == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public Date select(String name) {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql="select addtime from user where name=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            System.out.println("------------");
            while (rs.next()) {
                return rs.getDate(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
