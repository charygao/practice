package com.quantum.util;

import java.util.UUID;

/**
 * Created by zqq on 18-8-31.
 */
public class Utils {
    public static String getUUID32(){
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return uuid;
    }

    public static void main(String[] args) {
        System.out.println(getUUID32());
    }
}
