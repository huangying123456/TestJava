package com.page.pagechanging.service.imp;

import com.page.pagechanging.model.Page;
import com.page.pagechanging.model.Step;
import com.page.pagechanging.model.WorkingSet;
import com.page.pagechanging.service.Arithmetic;
import com.page.pagechanging.util.BinaryUtil;
import com.page.pagechanging.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 算法NUR
 * Created by ListenYoung on 15/9/1.
 */
public class NUR implements Arithmetic {

    class CheckElement{
        public int r = 0;
        public int m = 0;
        public int count = 0;

        public CheckElement(){}

        /**
         * 执行一次时钟累加
         */
        public void executePlus(){
            this.count ++ ;
            if(this.count >= NUR.DEAD_LINE){
                this.r = 0;
            }
        }

        /**
         * 执行一次访问操作
         */
        public void visit(){
            this.count = 0;
            this.r = 1;
            this.m = 1;
        }
    }

    public static final int DEAD_LINE = 3;          //以这个访问次数作为清零的界限

    private CheckElement[] checkList = null;

    /**
     * 对所有的标志位执行一次时钟累加
     */
    private void doPlus(){
        for(int i = 0 ; i < this.checkList.length ; i ++){
            this.checkList[i].executePlus();
        }
    }

    /**
     * 得到淘汰的页框的位置
     * @return 淘汰的页框的位置
     */
    private int getderelictPageLocation(){
        int result = 0;
        List<Integer> derelictList = new ArrayList<Integer>();
        for(int i = 0 ; i < this.checkList.length ; i ++){
            if(this.checkList[i].r == 0){
                derelictList.add(i);
            }
        }

        result = (int)(Math.random() * derelictList.size());

        return derelictList.get(result);
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
            this.checkList = new CheckElement[workingSet.getSize()];
            for(int i = 0 ; i < checkList.length ; i ++){
                checkList[i] = new CheckElement();
            }

            for(int i = 0 ; i < length ; i ++){
                Step step = new Step();
                step.setLogicArddress(addresses[i]);
                int pageNumber = BinaryUtil.parseInt(StringUtil.getFrontFourInt(addresses[i]));
                Page page = new Page();
                page.setStartAddress((pageNumber * WorkingSet.PAGE_FRAME_SIZE));

                if(workingSet.memoryIsEmpty()){
                    workingSet.loadPage(pageNumber);
                    page.setPageFrame(workingSet.getMemoryPoint() - 1);
                    doPlus();
                    this.checkList[workingSet.getMemoryPoint() - 1].visit();
                }else if(!workingSet.memoryIsFull()){
                    int temp = workingSet.isMemoryHavePageNumber(pageNumber);
                    if(temp != -1){
                        page.setPageFrame(temp);
                        doPlus();
                        this.checkList[temp].visit();
                    }else{
                        step.setIsStop(true);
                        workingSet.loadPage(pageNumber);
                        page.setPageFrame(workingSet.getMemoryPoint() - 1);
                        doPlus();
                        this.checkList[workingSet.getMemoryPoint() - 1].visit();
                    }
                }else{
                    int temp = workingSet.isMemoryHavePageNumber(pageNumber);
                    if(temp != -1){
                        page.setPageFrame(temp);
                        doPlus();
                        this.checkList[temp].visit();
                    }else{
                        step.setIsStop(true);
                        int derelictPage = getderelictPageLocation();
                        if(derelictPage > 0){
                            step.setDerelictPageNumber(derelictPage);
                            page.setPageFrame(derelictPage);
                            workingSet.setMemoryPageByIndex(derelictPage, pageNumber);
                            doPlus();
                            this.checkList[derelictPage].visit();
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
