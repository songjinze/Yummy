package com.yummy.module;
/*
 * author: SJZ
 * date: 2019/2/17
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ModuleConfig {

    @Bean
    @Scope("prototype")
    public ManagerBean getManagerBean(){
        return new ManagerBean();
    }


}
