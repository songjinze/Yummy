package com.yummy.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CheckCodeCreator {
    private Random random=new Random(10000);
    public String createCheckCode(){
        return random.nextInt(10000)+"";
    }
}
