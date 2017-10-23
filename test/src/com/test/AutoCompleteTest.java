package com.test;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ListenYoung on 2017/4/6.
 */

class Data{
    public Long id;
    public String name;

    public Data(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Data() {
    }
}

public class AutoCompleteTest {

    public static Map<String, List<Data>> prefixMap;

    public static void setMap(){
        prefixMap = new HashMap<>();
        List<Data> dataList = new ArrayList<>();
        dataList.add(new Data(1L, "我在"));
        dataList.add(new Data(2L, "我们代价"));
        dataList.add(new Data(3L, "我是人"));
        dataList.add(new Data(4L, "你是我"));
        dataList.add(new Data(5L, "我不会"));
        dataList.add(new Data(6L, "我是谁"));
        dataList.add(new Data(7L, "我和你"));

        Map<String, Long> dataMap = new HashMap<>();
        for(Data d : dataList){
            dataMap.put(d.name, d.id);
        }

        for(Map.Entry<String, Long> entry : dataMap.entrySet()){
            String temp = entry.getKey();
            for(int i = temp.length() ; i > 0 ; i --){
                String sub = temp.substring(0, i);
                if(prefixMap.get(sub) != null){
                    List<Data> list = prefixMap.get(sub);
                    list.add(new Data(entry.getValue(), entry.getKey()));
                    prefixMap.put(sub, list);
                }else{
                    List<Data> list = new ArrayList<>();
                    list.add(new Data(entry.getValue(), entry.getKey()));
                    prefixMap.put(sub, list);
                }
            }
        }

    }

    public static void main(String[] args){
        String str = "我是";
        //System.out.print(str.substring(0,2));
        setMap();
        List<Data> list = prefixMap.get(str);
        for(Data d : list){
            System.out.println(d.id);
            System.out.println(d.name);
        }
    }
}
