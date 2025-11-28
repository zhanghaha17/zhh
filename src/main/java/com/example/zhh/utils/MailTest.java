package com.example.zhh.utils;


import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.io.File;

public class MailTest {

    // 发件人配置类
    public static class SenderConfig {
        private String email;
        private String smtpHost;
        private int smtpPort;
        private String username;
        private String password;

        // 构造方法、getters和setters
        public SenderConfig(String email, String smtpHost, int smtpPort, String username, String password) {
            this.email = email;
            this.smtpHost = smtpHost;
            this.smtpPort = smtpPort;
            this.username = username;
            this.password = password;
        }
        // 省略getter/setter


        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getSmtpHost() {
            return smtpHost;
        }

        public void setSmtpHost(String smtpHost) {
            this.smtpHost = smtpHost;
        }

        public int getSmtpPort() {
            return smtpPort;
        }

        public void setSmtpPort(int smtpPort) {
            this.smtpPort = smtpPort;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    // 收件人配置类
    public static class RecipientConfig {
        private List<String> to = new ArrayList<>();
        private List<String> cc = new ArrayList<>();
        private List<String> bcc = new ArrayList<>();

        public void addTo(String email) { to.add(email); }
        public void addCc(String email) { cc.add(email); }
        public void addBcc(String email) { bcc.add(email); }
        // 省略getter
    }

    public static void sendEmail(SenderConfig sender,
                                 RecipientConfig recipients,
                                 String subject,
                                 String content,
                                 List<File> attachments) throws Exception {

/*        Properties props = new Properties();
        props.put("mail.smtp.host", sender.getSmtpHost());
        props.put("mail.smtp.port", sender.getSmtpPort());
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");*/



        Properties props = new Properties();
        props.put("mail.smtp.host", sender.getSmtpHost());
        props.put("mail.smtp.port", sender.getSmtpPort());
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");  // 必须启用SSL
// 部分环境需要添加以下配置
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", sender.getSmtpPort());

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender.getUsername(), sender.getPassword());
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sender.getEmail()));

        // 设置收件人
        if (!recipients.to.isEmpty()) {
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(String.join(",", recipients.to)));
        }
        if (!recipients.cc.isEmpty()) {
            message.setRecipients(Message.RecipientType.CC,
                    InternetAddress.parse(String.join(",", recipients.cc)));
        }
        if (!recipients.bcc.isEmpty()) {
            message.setRecipients(Message.RecipientType.BCC,
                    InternetAddress.parse(String.join(",", recipients.bcc)));
        }

        message.setSubject(subject);

        // 创建多部分内容
        Multipart multipart = new MimeMultipart();

        // 正文部分
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(content, "text/html; charset=utf-8");
        multipart.addBodyPart(messageBodyPart);

        // 附件部分
        for (File file : attachments) {
            BodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.setFileName(file.getName());
            ((MimeBodyPart) attachmentPart).attachFile(file);
            multipart.addBodyPart(attachmentPart);
        }

        message.setContent(multipart);
        Transport.send(message);
    }

    public static void main(String[] args) throws Exception {
        // QQ邮箱发件人配置
        SenderConfig qqSender = new SenderConfig(
                "1187907442@qq.com",
                "smtp.qq.com",
                465,
                "1187907442@qq.com",
                "przazyunbgcnggej"  // 替换为实际授权码
        );

        // 收件人配置
        RecipientConfig recipients = new RecipientConfig();
        recipients.addTo("1755743868@qq.com");
        recipients.addCc("@qq.com");

        // 附件配置
        List<File> attachments = new ArrayList<>();
        attachments.add(new File("/Users/zhanghaha/Documents/0225.txt"));  // 测试文件路径

        // 发送邮件
        sendEmail(qqSender, recipients,
                "QQ邮箱测试邮件",
                "<b>这是一封来自Java程序的测试邮件</b>",
                attachments);
    }

    /*
    public static void main(String[] args) throws Exception {
        // 配置多个发件人
        List<SenderConfig> senders = new ArrayList<>();
        senders.add(new SenderConfig(
                "sender1@company.com",
                "smtp.company.com",
                587,
                "sender1",
                "password1"
        ));
        senders.add(new SenderConfig(
                "sender2@department.com",
                "smtp.department.com",
                587,
                "sender2",
                "password2"
        ));

        // 配置收件人
        RecipientConfig recipients = new RecipientConfig();
        recipients.addTo("to1@example.com");
        recipients.addTo("to2@example.com");
        recipients.addCc("cc1@example.com");
        recipients.addBcc("bcc1@example.com");

        // 添加附件
        List<File> attachments = new ArrayList<>();
        attachments.add(new File("report.pdf"));
        attachments.add(new File("data.xlsx"));

        // 使用第一个发件人配置发送邮件
        sendEmail(senders.get(0), recipients,
                "测试邮件",
                "<h1>这是测试内容</h1><p>请查看附件</p>",
                attachments);
    }*/
}