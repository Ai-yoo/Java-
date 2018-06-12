package com.du.service;

import com.du.dao.UserDao;
import com.du.domain.User;
import com.du.util.EncodeMD5;
import com.du.util.SendMail;
import com.du.util.Time;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

/**
 * @author duzhentong
 */
public class AddServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        System.out.println(username);
        System.out.println(password);
        System.out.println(email);
        StringBuffer random = new StringBuffer();
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            random.append(r.nextInt(10));
        }
        System.out.println(random.toString());
        String randomcode = EncodeMD5.EncodeByMD5(random.toString());
        String time = Time.getDate();
        System.out.println(time);
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setRandomcode(randomcode);
        user.setAddtime(time);
        UserDao userdao = new UserDao();
        userdao.add(user);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        SendMail.sendMail(user.getName(),randomcode,email);
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
