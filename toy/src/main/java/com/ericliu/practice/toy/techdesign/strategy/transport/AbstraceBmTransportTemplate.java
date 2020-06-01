package com.ericliu.practice.toy.techdesign.strategy.transport;

import com.ericliu.practice.toy.techdesign.ValidateStrategy;
import com.ericliu.practice.toy.techdesign.factory.BmActTemplateValidateFactory;
import com.ericliu.practice.toy.techdesign.factory.BmTransportTemplateValidateFactory;

/**
 * @Author: liuhaoeric
 * Create time: 2020/06/01
 * Description:
 */
public abstract class AbstraceBmTransportTemplate implements ValidateStrategy {

    protected String code;

    public AbstraceBmTransportTemplate(String code) {
        this.code=code;
        BmTransportTemplateValidateFactory.getInstance().register(code, this);
    }

    @Override
    public String getCode() {
        return code;
    }
}
