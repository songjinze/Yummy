package com.yummy.util;

import org.springframework.stereotype.Component;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

@Component
public class EmailSender {

    private Message message;
    private Transport transport;

    EmailSender(){
        Properties prop = new Properties();
        prop.setProperty("mail.debug", "true");
        prop.setProperty("mail.smtp.auth","true" );
        prop.setProperty("mail.host", "smtp.qq.com");
        prop.setProperty("mail.transport.protocol", "smtp");
        Session session = Session.getInstance(prop);
        message = new MimeMessage(session);
        try {
            transport = session.getTransport();
            message.setSubject("验证码");
            message.setFrom(new InternetAddress("734609160@qq.com","Yummy"));
            transport.connect("smtp.qq.com","734609160@qq.com","bbngjdeiihrebaif");

        } catch (MessagingException | UnsupportedEncodingException e) {
            // e.printStackTrace();
        }
    }

    public void sendEmail(String toAddress,String context){
        try {
            message.setContent(context, "text/html;charset=utf-8");
            transport.sendMessage(this.message,new Address[]{
                    new InternetAddress(toAddress),new InternetAddress(toAddress)
            });
        } catch (MessagingException e) {
            //e.printStackTrace();
        }
    }
}
