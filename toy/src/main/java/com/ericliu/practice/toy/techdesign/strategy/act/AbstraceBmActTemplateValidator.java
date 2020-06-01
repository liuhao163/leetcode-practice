package com.ericliu.practice.toy.techdesign.strategy.act;

import com.ericliu.practice.toy.techdesign.ValidateStrategy;
import com.ericliu.practice.toy.techdesign.factory.BmActTemplateValidateFactory;

/**
 * @Author: liuhaoeric
 * Create time: 2020/06/01
 * Description:
 */
public abstract class AbstraceBmActTemplateValidator implements ValidateStrategy {

    protected String code;

    public AbstraceBmActTemplateValidator(String code) {
        this.code=code;
        BmActTemplateValidateFactory.getInstance().register(code, this);
    }

    @Override
    public String getCode() {
        return code;
    }
}
