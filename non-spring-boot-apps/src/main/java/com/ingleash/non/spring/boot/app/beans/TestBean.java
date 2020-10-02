package com.ingleash.non.spring.boot.app.beans;

import java.io.*;
import java.util.concurrent.CopyOnWriteArraySet;

public class TestBean {
    private String name;
    private String address;
    private OneMore oneMore;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }


    public String add() {
        return this.address;
    }


    public OneMore getOneMore() {
        return oneMore;
    }

    public void setOneMore(OneMore oneMore) {
        this.oneMore = oneMore;
    }
}
