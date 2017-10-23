package com.page.pagechanging.service;

import com.page.pagechanging.model.Step;
import com.page.pagechanging.model.WorkingSet;

import java.util.List;

/**
 * Created by ListenYoung on 15/9/1.
 */
public interface Arithmetic {

    public abstract List<Step> doArithmetic (WorkingSet workingSet);

}
