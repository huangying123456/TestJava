package com.page.pagechanging.service.imp;

import com.page.pagechanging.model.Page;
import com.page.pagechanging.model.Step;
import com.page.pagechanging.model.WorkingSet;
import com.page.pagechanging.service.Arithmetic;
import com.page.pagechanging.util.BinaryUtil;
import com.page.pagechanging.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 算法LRU
 * Created by ListenYoung on 15/9/1.
 */
public class LRU implements Arithmetic {

    private int[][] counter = null;

    /**
     * 维护淘汰页面的矩阵的操作
     * @param pageNumber 插入内存的页面的位置
     */
    private void setPage(int pageNumber){
        int length = this.counter.length;
        for(int i = 0 ; i < length ; i ++){
            this.counter[pageNumber][i] = 1;
        }

        for(int i = 0 ; i < length ; i ++){
            this.counter[i][pageNumber] = 0;
        }
    }

    /**
     * 得到淘汰的页框的位置
     * @return 淘汰的页框的位置
     */
    private int getderelictPageLocation(){
        int result = -1;
        int max = 0;
        for(int i = 0 ; i < this.counter.length ; i ++){
            int temp = BinaryUtil.parseInt(this.counter[i]);
            if(temp > max){
                max = temp;
                result = i;
            }
        }
        return result;
    }

    @Override
    public List<Step> doArithmetic(WorkingSet workingSet) {

        List<Step> result = null;
        if(workingSet == null || workingSet.getSize() < 1){
            //传入的工作集非法
        }else{
            result = new ArrayList<Step>();
            String[] addresses = workingSet.getAddresses();
            int length = addresses.length;
            int[] fillElement = new int[workingSet.getSize()];
            this.counter = new int[workingSet.getSize()][workingSet.getSize()];
            Arrays.fill(counter , fillElement);

            for(int i = 0 ; i < length ; i ++){
                Step step = new Step();
                step.setLogicArddress(addresses[i]);
                int pageNumber = BinaryUtil.parseInt(StringUtil.getFrontFourInt(addresses[i]));
                Page page = new Page();
                page.setStartAddress((pageNumber * WorkingSet.PAGE_FRAME_SIZE));

                if(workingSet.memoryIsEmpty()){
                    workingSet.loadPage(pageNumber);
                    page.setPageFrame(workingSet.getMemoryPoint() - 1);
                    setPage(workingSet.getMemoryPoint() - 1);
                }else if(!workingSet.memoryIsFull()){
                    int temp = workingSet.isMemoryHavePageNumber(pageNumber);
                    if(temp != -1){
                        page.setPageFrame(temp);
                        setPage(temp);
                    }else{
                        step.setIsStop(true);
                        workingSet.loadPage(pageNumber);
                        page.setPageFrame(workingSet.getMemoryPoint() - 1);
                        setPage(workingSet.getMemoryPoint() - 1);
                    }
                }else{
                    int temp = workingSet.isMemoryHavePageNumber(pageNumber);
                    if(temp != -1){
                        page.setPageFrame(temp);
                        setPage(temp);
                    }else{
                        step.setIsStop(true);
                        int derelictPage = getderelictPageLocation();
                        if(derelictPage != -1){
                            step.setDerelictPageNumber(derelictPage);
                            page.setPageFrame(derelictPage);
                            workingSet.setMemoryPageByIndex(derelictPage , pageNumber);
                            setPage(pageNumber);
                        }
                    }
                }
                step.setPage(page);
                step.copyArray(workingSet.getMemoryPages());
                result.add(step);
            }
        }

        return result;
    }
}
