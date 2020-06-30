package com.util.www;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
 
/**
 * @Auther: liangbl
 * @Date: 2018/12/21 10:53
 * @Description:
 */
public class MailUtils {
    // 邮箱用户名
    public static String userName="418020360@qq.com";
    // 邮箱授权码(非邮箱登录密码)
    public static String password="xiadaHUANGqf.";
 
    /**
     * 发送邮件
     * @param email 要发送的邮箱地址
     * @param subject 邮件标题
     * @param emailMsg 邮件内容
     */
    public static void sendMail(String email, String subject, String emailMsg) throws Exception {
        // 1.创建一个程序与邮件服务器会话对象 Session
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "SMTP");
        props.setProperty("mail.host", "smtp.qq.com");
        props.setProperty("mail.smtp.auth", "true");// 指定验证为true
        // 创建验证器
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(props, auth);
        // 2.创建一个Message，它相当于是邮件内容
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(userName)); // 设置发送者
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email)); // 设置发送方式与接收者
        message.setSubject(subject);
        // message.setText("这是一封激活邮件，请<a href='#'>点击</a>");
        message.setContent(emailMsg, "text/html;charset=utf-8");
        // 3.创建 Transport用于将邮件发送
        Transport.send(message);
    }
 
    public static void main(String[] args) {
        try {
            sendMail("qfhuang.2018@mitb.smu.edu.sg","邮箱工具类测试","test email");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ok");
    }
}