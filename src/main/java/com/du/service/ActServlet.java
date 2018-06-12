package com.du.service;

import com.du.dao.UserDao;
import com.du.domain.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;


@WebServlet(name = "ActServlet")
public class ActServlet extends HttpServlet {

    //规定注册的时间间隔
    private static final int SET_TIME = 7200;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String randomcode = request.getParameter("randomcode");
        System.out.println(username);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println(user);
        UserDao userDao = new UserDao();
        Date date = new Date();
        Date date1 = userDao.select(username);
        long nowtime = date.getTime() / 1000;
        long addtime = date1.getTime() / 1000;
        System.out.println(nowtime);
        System.out.println(addtime);
        System.out.println(nowtime-addtime);
        if ((nowtime - addtime) > SET_TIME) {
            userDao.delete(username);
            response.sendRedirect("/lost.jsp");
        }else{
            if (user.getName().equals(username) && user.getRandomcode().equals(randomcode)) {
                userDao.update(username);
                response.sendRedirect("/login.jsp");
            } else {
                response.sendRedirect("/login.jsp");
            }
        }
    }

}
