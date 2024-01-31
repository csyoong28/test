package com.soonyoong.junit;

public class User {

    String name;
    String phone;
    String areaCode;

    String operatorCode;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", operatorCode='" + operatorCode + '\'' +
                '}';
    }

    public User(String name, String phone, String areaCode, String operatorCode) {
        this.name = name;
        this.phone = phone;
        this.areaCode = areaCode;
        this.operatorCode = operatorCode;
    }
}
