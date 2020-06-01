package com.ericliu.practice.toy.techdesign.strategy.transport;

import com.ericliu.practice.toy.techdesign.strategy.act.AbstraceBmActTemplateValidator;

/**
 * @Author: liuhaoeric
 * Create time: 2020/06/01
 * Description:
 */
public class FirstBmTransportTemplateImpl extends AbstraceBmTransportTemplate {

    public FirstBmTransportTemplateImpl() {
        super("T1");
        /**
         * 此处省略1000行创建代码。。。。
         */
    }

    @Override
    public void validate(Object entity) {
        System.out.println(getCode()+" " + entity);
    }

}
