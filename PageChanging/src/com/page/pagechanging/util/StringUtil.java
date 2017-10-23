package com.page.pagechanging.util;

import com.page.pagechanging.model.WorkingSet;

/**
 * 字符串工具类
 * Created by ListenYoung on 15/8/26.
 */
public class StringUtil {
    /**
     * 得到十六位逻辑地址的前四位
     * @param str 十六位逻辑地址
     * @return 前五位地址
     */
    public static int getFrontFourInt(String str){
        int result = 0;
        if(str == null || str.length() != WorkingSet.LOGIC_ADDRESS_BIT){
            result = -1;
        }else{
            int time = 1000;
            for(int i = 0 ; i < 4 ; i ++){
                result += time * (str.charAt(i) - '0');
                time /= 10;
            }
        }
        return result;
    }
}
