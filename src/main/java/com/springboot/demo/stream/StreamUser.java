package com.springboot.demo.stream;

/**
 * @program hr-core
 * @description: ttttt
 * @author: jason
 * @create: 2019-08-18 00:16
 */
public class StreamUser {
    private String name;
    private Integer age;

    public StreamUser(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "testUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
