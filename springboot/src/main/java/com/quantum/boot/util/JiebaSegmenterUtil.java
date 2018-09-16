package com.quantum.boot.util;

import com.huaban.analysis.jieba.JiebaSegmenter;

import java.util.List;
import java.util.StringJoiner;

/**
 * Created by zqq on 18-8-19.
 */
public class JiebaSegmenterUtil {

    private static JiebaSegmenter tokenizer = new JiebaSegmenter();

    public static String segment(String sentence){
        List<String> r = tokenizer.sentenceProcess(sentence);
        StringJoiner joiner = new StringJoiner(" ");

        r.forEach( s -> joiner.add(s));
        return joiner.toString();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {

            System.out.println(segment("我是温涛发 温总，最近招聘有什么新的进展吗？"));
        }

        System.out.println(System.currentTimeMillis() -start);
    }
}
