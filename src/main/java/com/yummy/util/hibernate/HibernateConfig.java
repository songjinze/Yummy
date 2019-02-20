package com.yummy.util.hibernate;
/*
 * author: SJZ
 * date: 2019/2/20
 */

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfig {

    @Bean
    public SessionFactory sessionFactory(){
        final StandardServiceRegistry registry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        return new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }
}
