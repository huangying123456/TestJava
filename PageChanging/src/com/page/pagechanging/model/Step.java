package com.page.pagechanging.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 算法运行时每一步的数据记录
 * Created by ListenYoung on 15/9/1.
 */
public class Step {
    private String logicArddress;       //访问的逻辑地址
    private Page page;                  //对应的逻辑页面
    private boolean isStop;             //是否发生缺页中断
    private int derelictPageNumber;     //淘汰的页号
    private List<TableElement> map;     //这步操作结束时的逻辑地址和内存页框的映射表

    public String getLogicArddress() {
        return logicArddress;
    }

    public void setLogicArddress(String logicArddress) {
        this.logicArddress = logicArddress;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public boolean isStop() {
        return isStop;
    }

    public void setIsStop(boolean isStop) {
        this.isStop = isStop;
    }

    public int getDerelictPageNumber() {
        return derelictPageNumber;
    }

    public void setDerelictPageNumber(int derelictPageNumber) {
        this.derelictPageNumber = derelictPageNumber;
    }

    public List<TableElement> getMap() {
        return map;
    }

    public void setMap(List<TableElement> map) {
        this.map = map;
    }

    public Step() {
        this.map = new ArrayList<TableElement>();
        this.isStop = false;
    }

    /**
     * 将传入的数组转化为类中的map
     * @param array 需要转化的数组
     */
    public void copyArray(int[] array){
        int length = array.length;
        for(int i = 0 ; i < length ; i ++){
            TableElement element = new TableElement();
            element.physicsPageNumber = i;
            element.logicPageNumber = array[i];
            this.map.add(element);
        }
    }
}
