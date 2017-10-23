package com.page.pagechanging.model;

/**
 * 逻辑页面类
 * Created by ListenYoung on 15/8/26.
 */
public class Page {
    private int startAddress;       //逻辑页面的起始地址
    private int pageFrame;          //逻辑页面对应的物理内存页框
    public int getStartAddress() {
        return startAddress;
    }
    public void setStartAddress(int startAddress) {
        this.startAddress = startAddress;
    }
    public int getPageFrame() {
        return pageFrame;
    }
    public void setPageFrame(int pageFrame) {
        this.pageFrame = pageFrame;
    }
    public Page(int startAddress, int pageFrame) {
        this.startAddress = startAddress;
        this.pageFrame = pageFrame;
    }
    public Page() {
        this.pageFrame = -1;
    }

}
