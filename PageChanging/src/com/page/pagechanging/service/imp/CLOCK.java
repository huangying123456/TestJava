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
 * 算法CLOCK
 * Created by ListenYoung on 15/9/1.
 */
public class CLOCK implements Arithmetic {

    class CheckElement{
        public int r;
        public int page;
        public CheckElement next;

        public CheckElement(){
            r = 0;
            this.page = -1;
            this.next = null;
        }

        public void visit(){
            this.r = 1;
        }

        public CheckElement createLinkedList(int n){
            CheckElement head = new CheckElement();
            CheckElement temp = head.next;
            for(int i = 1 ; i < n ; i ++){
                temp = new CheckElement();
                temp = temp.next;
            }
            temp = head;
            return head;
        }

    }

    /**
     * 得到淘汰的页框的位置
     * @return 淘汰的页框的位置
     */
    private int getderelictPageLocation(CheckElement head , int pageNumber){
        int result = -1;
        if(head != null){
            while(head.r == 0){
                head = head.next;
            }
            result = head.page;
            head.page = pageNumber;
            head.visit();
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
            CheckElement creator = new CheckElement();
            CheckElement head = creator.createLinkedList(workingSet.getSize());

            for(int i = 0 ; i < length ; i ++){
                Step step = new Step();
                step.setLogicArddress(addresses[i]);
                int pageNumber = BinaryUtil.parseInt(StringUtil.getFrontFourInt(addresses[i]));
                Page page = new Page();
                page.setStartAddress((pageNumber * WorkingSet.PAGE_FRAME_SIZE));

                if(workingSet.memoryIsEmpty()){
                    workingSet.loadPage(pageNumber);
                    page.setPageFrame(workingSet.getMemoryPoint() - 1);
                    head.page = workingSet.getMemoryPoint() - 1;
                    head.visit();
                    head = head.next;
                }else if(!workingSet.memoryIsFull()){
                    int temp = workingSet.isMemoryHavePageNumber(pageNumber);
                    if(temp != -1){
                        page.setPageFrame(temp);
                    }else{
                        step.setIsStop(true);
                        workingSet.loadPage(pageNumber);
                        page.setPageFrame(workingSet.getMemoryPoint() - 1);
                        head.page = workingSet.getMemoryPoint() - 1;
                        head.visit();
                        head = head.next;
                    }
                }else{
                    int temp = workingSet.isMemoryHavePageNumber(pageNumber);
                    if(temp != -1){
                        page.setPageFrame(temp);
                    }else{
                        step.setIsStop(true);
                        int derelictPage = getderelictPageLocation(head , pageNumber);
                        if(derelictPage != -1){
                            step.setDerelictPageNumber(derelictPage);
                            page.setPageFrame(derelictPage);
                            workingSet.setMemoryPageByIndex(derelictPage, pageNumber);
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
