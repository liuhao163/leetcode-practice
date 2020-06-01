package com.ericliu.practice.toy.techdesign.strategy.act;

/**
 * @Author: liuhaoeric
 * Create time: 2020/06/01
 * Description:
 */
public class SecBmActTemplateImpl extends AbstraceBmActTemplateValidator {

    public SecBmActTemplateImpl() {
        super("A2");
    }

    @Override
    public void validate(Object entity) {
        System.out.println("this is sec");
        System.out.println(getCode()+" " + entity);
    }

}
