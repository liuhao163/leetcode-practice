package com.ericliu.practice.toy.techdesign.strategy.act;

/**
 * @Author: liuhaoeric
 * Create time: 2020/06/01
 * Description:
 */
public class FirstBmActTemplateImpl extends AbstraceBmActTemplateValidator {

    public FirstBmActTemplateImpl() {
        super("A1");
    }

    @Override
    public void validate(Object entity) {
        System.out.println(getCode()+" " + entity);
    }

}
