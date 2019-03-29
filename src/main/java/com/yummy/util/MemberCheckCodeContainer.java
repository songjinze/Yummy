package com.yummy.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Hashtable;

@Component
public class MemberCheckCodeContainer {

    private final EmailSender emailSender;
    private final CheckCodeCreator checkCodeCreator;
    private Hashtable<String,String> con=new Hashtable<>();

    @Autowired
    public MemberCheckCodeContainer(EmailSender emailSender, CheckCodeCreator checkCodeCreator) {
        this.emailSender = emailSender;
        this.checkCodeCreator = checkCodeCreator;
    }

    public String getCodeByEmail(String memberEmail){
        return con.get(memberEmail);
    }

    public void sendAndCreateCode(String memberEmail){
        String checkCode=checkCodeCreator.createCheckCode();
        con.put(memberEmail,"验证码为："+checkCode);
        emailSender.sendEmail(memberEmail,checkCode);
    }

    public void alreadySignUp(String email){
        con.remove(email);
    }
}
