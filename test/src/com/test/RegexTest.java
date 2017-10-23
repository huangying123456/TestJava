package com.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ListenYoung on 2017/3/22.
 */
public class RegexTest {
    public static String regex(String str){

        String str1 = new String();
        String str2 = new String();
        //\(([一|二|三])([特|甲|乙|丙])
        String regex1 = "\\(([一|二|三])([特|甲|乙|丙])";
        String regex2 = "\\(([一|二|三])";
        Pattern pattern = Pattern.compile(regex1);
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
            str1 = matcher.group(1);
            str2 = matcher.group(2);
            return str1+"级"+str2+"等";
        }

        pattern = Pattern.compile(regex2);
        matcher = pattern.matcher(str);
        if(matcher.find()){
            str1 = matcher.group(1);
            return str1+"级医院";
        }

        return "其他";
    }
    public static void main(String[] args){
        System.out.println(RegexTest.regex("(贼爽老妇女    ,aeoufhiefhuoe)"));
    }
}
