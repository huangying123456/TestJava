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
 * 算法FIFO
 * Created by ListenYoung on 15/9/1.
 */
public class FIFO implements Arithmetic{
    @Override
    public List<Step> doArithmetic(WorkingSet workingSet) {
        List<Step> result = null;

        if(workingSet == null || workingSet.getSize() < 1){
            //传入的工作集非法
        }else{
            result = new ArrayList<Step>();
            String[] addresses = workingSet.getAddresses();
            int length = addresses.length;
            for(int i = 0 ; i < length ; i ++){
                Step step = new Step();
                step.setLogicArddress(addresses[i]);
                int pageNumber = BinaryUtil.parseInt(StringUtil.getFrontFourInt(addresses[i]));
                Page page = new Page();
                page.setStartAddress((pageNumber * WorkingSet.PAGE_FRAME_SIZE));

                if(workingSet.memoryIsEmpty()){
                    workingSet.loadPage(pageNumber);
                    page.setPageFrame(workingSet.getMemoryPoint() - 1);
                }else if(!workingSet.memoryIsFull()){
                    int temp = workingSet.isMemoryHavePageNumber(pageNumber);
                    if(temp != -1){
                        page.setPageFrame(temp);
                    }else{
                        step.setIsStop(true);
                        workingSet.loadPage(pageNumber);
                        page.setPageFrame(workingSet.getMemoryPoint() - 1);
                    }
                }else{
                    int temp = workingSet.isMemoryHavePageNumber(pageNumber);
                    if(temp != -1){
                        page.setPageFrame(temp);
                    }else{
                        workingSet.setMemoryPageByIndex(workingSet.getSize() - 1 , pageNumber);
                        step.setIsStop(true);
                        int[] memorys = workingSet.getMemoryPages();
                        step.setDerelictPageNumber(memorys[memorys.length - 1]);
                        page.setPageFrame(workingSet.getMemoryPoint());
                    }
                }
                System.out.println("一次");
                step.setPage(page);
                step.copyArray(workingSet.getMemoryPages());
                result.add(step);
            }


        }

        return result;
    }
}
