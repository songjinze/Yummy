package com.yummy.util;
/*
 * author: SJZ
 * date: 2019/2/21
 */

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ProductList implements Serializable {
    private Map<String,Integer> pnameList=new HashMap<>();

    public void addProduct(String productName,int num){
        if(pnameList.containsKey(productName)){
            pnameList.put(productName,pnameList.get(productName)+num);
        }else{
            pnameList.put(productName,num);
        }
    }

    public Map<String, Integer> getPnameList() {
        return pnameList;
    }
}
