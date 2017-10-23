package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by ListenYoung on 2017/7/27.
 */
public class TestException {
    public static void main(String[] args){
        try {
            int i = 1 / 0;
        }catch (Exception e){
            System.out.println(printExceptionInfo(e));
        }
    }

    public static String printExceptionInfo(Exception exception){
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exception.printStackTrace(printWriter);
        printWriter.flush();
        stringWriter.flush();
        String result = stringWriter.toString();
        if(printWriter != null){
            printWriter.close();
        }
        if(stringWriter != null){
            try {
                stringWriter.close();
            } catch (IOException e) {
                stringWriter = null;
            }
        }
        return result;
    }
}
