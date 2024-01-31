package com.soonyoong.junit;

public class FindUtils {

    public static String getAreaCode(String phoneNumber) {

        return phoneNumber.substring(0,2);
    }

    public static String getOperatorCode(String phoneNumber) {

        return phoneNumber.substring(0,2);
    }

}
