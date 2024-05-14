package com.springboot.demo;


/**
 * @program ac-zm-oa-cloud
 * @description:
 * @author: qitengjie
 * @create: 2022-05-12 15:47
 */

public class StudentDO {
    private String name;
    private String address;

    public StudentDO() {
    }

    public StudentDO(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
