package com.yummy.util;

import com.yummy.module.responsemodule.memberResponse.MemberOrderModule;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        MemberOrderModule memberOrderModule;
        OneOrder(MemberOrderModule memberOrderModule){
            this.memberOrderModule=memberOrderModule;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(300000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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

    }
}
