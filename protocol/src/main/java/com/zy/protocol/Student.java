package com.zy.protocol;

import java.io.Serializable;

public class Student implements Serializable {
    private String username;
    private String password;
    private String email;
    private int age;
    private long timespane;
    private double dValue;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getTimespane() {
        return timespane;
    }

    public void setTimespane(long timespane) {
        this.timespane = timespane;
    }

    public double getdValue() {
        return dValue;
    }

    public void setdValue(double dValue) {
        this.dValue = dValue;
    }
}
