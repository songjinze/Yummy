package com.yummy.util;
/*
 * author: SJZ
 * date: 2019/2/21
 */

import java.io.Serializable;

public class Address implements Serializable {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
