package com.page.pagechanging.model;

import com.page.pagechanging.util.BinaryUtil;
import com.page.pagechanging.util.StringUtil;

import java.util.Arrays;

/**
 * 工作集
 * Created by ListenYoung on 15/8/26.
 */
public class WorkingSet {
    public static int PAGE_FRAME_SIZE = 4096;       //页框的大小为4096byte
    public static int LOGIC_ADDRESS_BIT = 16;       //逻辑地址访问序列为16位
    public static String FIFO = "fifo";
    public static String LRU = "lru";
    public static String NUR = "nur";
    public static String CLOCK = "clock";
    private int size;                               //工作集的大小
    private String[] addresses;                     //逻辑地址的序列数组
    private Page[] pages;                           //进程逻辑页面数组
    private int memoryPoint;                        //这里多维护了一个int型变量，用于指示memory现在的空间状况
    private int[] memoryPages;


    /**
     * 创建一个虚拟内存序列,即页表列
     * @param size 要创建的页表的个数
     * @return 是否创建成功
     */
    public boolean createPages(int size){
        boolean result = false;
        if(size > 0){
            this.pages = new Page[size];
            for(int i = 0 ; i < size ; i ++){
                pages[i] = new Page();
                pages[i].setPageFrame(PAGE_FRAME_SIZE * i);
            }
            result = true;
        }
        return result;
    }

    /**
     * 创建一个访问的虚拟地址列表
     * @param size 需要创建的虚拟地址的个数
     * @return 是否创建成功
     */
    public boolean createAddresses(int size){
        boolean result = false;
        int pageSize = this.getpagesSize();
        String element;
        int test;
        //如果产生的16位逻辑地址超过了page的大小，那么就是无用的垃圾地址，这样的地址会导致程序崩溃，必须排查
        if(size > 0){
            addresses = new String[size];
            for(int i = 0 ; i < size ; i ++){
                System.out.println("这是第"+i);
                while(true){
                    System.out.println("尝试创建随机数");
                    element = BinaryUtil.getSixteenBinary();
                    test = BinaryUtil.parseInt(StringUtil.getFrontFourInt(element));
                    if(test < pageSize){
                        this.addresses[i] = element;
                        break;
                    }
                }
            }
        }

        return result;
    }

    /**
     * 将逻辑页面装入物理内存页框
     * @param page 需要装入的页框
     */
    public void loadPage(int page){
        this.memoryPages[this.memoryPoint] = page;
        this.memoryPoint ++;
    }

    /**
     * 得到页表的个数
     * @return 页表的个数
     */
    public int getpagesSize(){
        if(pages != null){
            return pages.length;
        }else{
            return 0;
        }
    }

    /**
     * 创建工作集
     * @param size 工作集的大小 pageSize 页表个数 addressSize 地址个数
     */
    private void createWorkingSet(int pageSize , int addressSize , int size){
        this.size  = size;
        createPages(pageSize);
        createAddresses(addressSize);
        this.memoryPages = new int[size];
        Arrays.fill(this.memoryPages , -1);
        this.memoryPoint = 0;
    }

    /**
     *内存是否为空
     * @return 是否为空
     */
    public boolean memoryIsEmpty(){
        return (this.memoryPoint == 0);
    }

    /**
     * 内存是否已满
     * @return 是否已满
     */
    public boolean memoryIsFull(){
        return (this.memoryPages.length - 1 == this.memoryPoint);
    }

    /**
     * 当前的物理内存中是否包含传入的逻辑页码
     * @param pageNumber 传入的逻辑页码
     * @return 逻辑页码对应的位置，若没有则返回-1
     */
    public int isMemoryHavePageNumber(int pageNumber){
        int result = -1;
        for(int i = 0 ; i < this.size ; i ++){
            if(this.memoryPages[i] == pageNumber){
                result = i;
                break;
            }
        }
        return result;
    }

    /**
     * 用逻辑页面替换当前内存中指定的页框
     * @param index 指定的物理内存中的页框的索引
     * @param page 需要替换的逻辑页框
     */
    public void setMemoryPageByIndex(int index , int page){
        this.memoryPages[index] = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String[] getAddresses() {
        return addresses;
    }

    public void setAddresses(String[] addresses) {
        this.addresses = addresses;
    }

    public Page[] getPages() {
        return pages;
    }

    public void setPages(Page[] pages) {
        this.pages = pages;
    }

    public int getMemoryPoint() {
        return memoryPoint;
    }

    public void setMemoryPoint(int memoryPoint) {
        this.memoryPoint = memoryPoint;
    }

    public int[] getMemoryPages() {
        return memoryPages;
    }

    public void setMemoryPages(int[] memoryPages) {
        this.memoryPages = memoryPages;
    }

    public WorkingSet(){}

    public WorkingSet(int pageSize , int addressSize , int size){
        if(size > 0 && addressSize > 0 && pageSize > 0){
            createWorkingSet(pageSize , addressSize , size);
        }
    }
}
