package com.yummy.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Hashtable;
import java.util.Random;

@Component
public class MemberCheckCodeContainer {

    private final EmailSender emailSender;
    private Hashtable<String,String> con=new Hashtable<>();

    @Autowired
    public MemberCheckCodeContainer(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public String getCodeByEmail(String memberEmail){
        return con.get(memberEmail);
    }

    public void sendAndCreateCode(String memberEmail){
        Random random=new Random(10000);
        String checkCode= random.nextInt(10000)+"";
        con.put(memberEmail,checkCode);
        emailSender.sendEmail(memberEmail,"验证码为："+checkCode);
    }

    public void alreadySignUp(String email){
        con.remove(email);
    }
}
