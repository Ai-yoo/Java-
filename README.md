# JavaMail项目介绍
目前的功能：运行项目，用户需要注册，注册页面的表单采用jQuery验证，判断用户的用户名，密码，邮箱是否输入符合规范。  
点击提交之后，调用数据库操作代码，调用发送邮件代码。把用户的基本信息加入数据库，但是这时用户还没有权限，当用户点击邮箱中的链接激活后账号才可以正常使用，否则是登录不上的  
2017-10-28添加数据库连接池  
获取链接时需读取配置文件，这样在更改数据库的时候只需要更改配置文件即可  
发往用户的邮箱的验证码采用UUID，保证唯一性  
修改实体类属性和数据库中表相对应  
未完……
