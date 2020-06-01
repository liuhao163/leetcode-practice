package com.ericliu.practice.toy.techdesign.strategy.transport;

import com.ericliu.practice.toy.techdesign.strategy.act.AbstraceBmActTemplateValidator;

/**
 * @Author: liuhaoeric
 * Create time: 2020/06/01
 * Description:
 */
public class SecBmTransportTemplateImpl extends AbstraceBmTransportTemplate {

    public SecBmTransportTemplateImpl() {
        super("T2");
    }

    @Override
    public void validate(Object entity) {
        System.out.println(getCode()+" " + entity);
    }

}
