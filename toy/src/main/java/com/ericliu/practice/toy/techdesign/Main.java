package com.ericliu.practice.toy.techdesign;

import com.ericliu.practice.toy.techdesign.factory.BmActTemplateValidateFactory;
import com.ericliu.practice.toy.techdesign.factory.BmTransportTemplateValidateFactory;
import com.ericliu.practice.toy.techdesign.strategy.act.FirstBmActTemplateImpl;
import com.ericliu.practice.toy.techdesign.strategy.act.SecBmActTemplateImpl;
import com.ericliu.practice.toy.techdesign.strategy.transport.FirstBmTransportTemplateImpl;
import com.ericliu.practice.toy.techdesign.strategy.transport.SecBmTransportTemplateImpl;

/**
 * @Author: liuhaoeric
 * Create time: 2020/06/01
 * Description:
 */
public class Main {
    public static void main(String[] args) {
        new FirstBmActTemplateImpl();
        new SecBmActTemplateImpl();
        new FirstBmTransportTemplateImpl();
        new SecBmTransportTemplateImpl();

        BmTransportTemplateValidateFactory.getInstance().validateByCode("T1"," 测试1");

        BmActTemplateValidateFactory.getInstance().validateByCode("A1"," 测试2");
    }
}
