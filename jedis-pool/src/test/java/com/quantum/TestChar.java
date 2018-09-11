package com.quantum;


import java.io.UnsupportedEncodingException;

/**
 * Created by zqq on 18-9-12.
 */
public class TestChar {
    static char c = '中' ;
    static char a = 123;
    static String str = "我是周海洋" ;


    public static void main(String[] args) throws UnsupportedEncodingException {

        System.out.println((int)c);


        System.out.println(a);

        System.out.println((int) c);

        for (char  cc : str.toCharArray()){
            System.out.println((int)cc);
        }


        System.out.println(str.length());
        System.out.println(str.getBytes().length);
        char[] s = new char[]{ c} ;
        System.out.println(s.length);
        System.out.println(new String(s).getBytes().length);

        String c="中";
        System.out.println(c.getBytes("GBK").length);

    }

}
