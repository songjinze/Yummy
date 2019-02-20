package com.yummy.util.exception;
/*
 * author: SJZ
 * date: 2019/2/20
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ExceptionRecorderConfig {
    @Bean
    @Scope("singleton")
    public ExceptionRecorder getErrorRecorder(){
        return new ExceptionRecorder();
    }
}
