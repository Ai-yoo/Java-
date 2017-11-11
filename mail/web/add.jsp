<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/9/12
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>注册页面</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/normalize/7.0.0/normalize.css">
    <link href="css/input.css" rel="stylesheet" type="text/css" media="all" />
  </head>
  <body>
  <div class="form">
  <form action="AddServlet" method="post">
    <div class="int">
      <label for="username">用户名:</label>
      <!-- 为每个需要的元素添加required -->
      <input type="text" id="username" class="required" name="username"/>
    </div>
    <div class="int">
      <label for="password">密码:</label>
      <!-- 为每个需要的元素添加required -->
      <input type="password" id="password" class="required" name="password"/>
    </div>
    <div class="int">
      <label for="email">邮箱:</label>
      <input type="text" id="email" class="required" name="email"/>
    </div>
    <div class="sub">
    <input type="submit" value="提交" id="send" onclick="this.disabled=true; this.value='提交中...';">
    <input type="reset" value="重置" id="res">
    </div>
  </div>
  </form>
  <script src="https://cdn.bootcss.com/jquery/3.0.0/jquery.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/check.js"></script>
  </body>
</html>
