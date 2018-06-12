package com.du.util;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

public class SendMail {
    public static void sendMail (String name,String code,String email){

        Properties props = new Properties();
        // 开启debug调试
        props.setProperty("mail.debug", "true");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", "smtp.qq.com");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");

        MailSSLSocketFactory sf = null;
        Message msg = null;
        Transport transport = null;
        try {
            sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.ssl.socketFactory", sf);

            Session session = Session.getInstance(props);

            msg = new MimeMessage(session);
            msg.setSubject("请尽快注册激活");
            // 设置邮件内容
            StringBuffer strBody = new StringBuffer();
            strBody.append("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
            strBody.append("<a href='http://localhost:8080/ActServlet?username="+name+"&randomcode="+code+"'>点击这里</a></br>");
            //发邮箱件
            msg.setContent(strBody.toString(),"text/html;charset=UTF-8");
            msg.setSentDate(new Date());
            msg.setFrom(new InternetAddress("18846054508@163.com", "激活账户邮件", "utf-8"));

            transport = session.getTransport();
            transport.connect("smtp.163.com", "18846054508@163.com", "163shouquanma");

            //收件邮箱
            transport.sendMessage(msg, new Address[] { new InternetAddress(email) });
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            try {
                transport.close();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }

//    public static void main(String[] args) {
//        SendMail.sendMail("a");
//    }
}
