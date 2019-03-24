package com.yummy.util;

import com.yummy.module.responsemodule.memberResponse.MemberOrderModule;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.System.gc;

@Component
@Scope("singleton")
public class OrderTimer {
    private Hashtable<String, List<MemberOrderModule>> orderModuleHashSet;
    private ExecutorService executorService;

    public OrderTimer(){
        orderModuleHashSet=new Hashtable<>();
        executorService=Executors.newCachedThreadPool();
    }

    class OneOrder implements Runnable{
        private MemberOrderModule memberOrderModule;
        private String memberEmail;
        OneOrder(String memberEmail,MemberOrderModule memberOrderModule){
            this.memberOrderModule=memberOrderModule;
            this.memberEmail=memberEmail;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(300000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            orderModuleHashSet.get(memberEmail).remove(memberOrderModule);
        }
    }
    public void addOrder(String memberEmail,MemberOrderModule memberOrderModule){
        List<MemberOrderModule> memberOrderModules;
        if(orderModuleHashSet.containsKey(memberEmail)){
            memberOrderModules=orderModuleHashSet.get(memberEmail);
        }else{
            memberOrderModules=new LinkedList<>();
        }
        memberOrderModules.add(memberOrderModule);
        orderModuleHashSet.put(memberEmail,memberOrderModules);
        OneOrder oneOrder=new OneOrder(memberEmail,memberOrderModule);
        executorService.execute(oneOrder);
    }

    public List<MemberOrderModule> getMemberOrderModulesByEmail(String memberEmail){
        if(orderModuleHashSet.containsKey(memberEmail)){
            return orderModuleHashSet.get(memberEmail);
        }else{
            return new ArrayList<>();
        }
    }
}
