package com.ericliu.practice.toy.techdesign.factory;

import com.ericliu.practice.toy.techdesign.StrategyFactroy;
import com.ericliu.practice.toy.techdesign.ValidateStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liuhaoeric
 * Create time: 2020/06/01
 * Description:
 */
public class BmActTemplateValidateFactory implements StrategyFactroy {

    private static BmActTemplateValidateFactory instance=new BmActTemplateValidateFactory();

    private BmActTemplateValidateFactory(){}

    public static BmActTemplateValidateFactory getInstance() {
        return instance;
    }

    private Map<String, ValidateStrategy> map = new HashMap<>();

    @Override
    public void register(String code, ValidateStrategy strategy) {
        map.put(code, strategy);
    }

    @Override
    public void validateByCode(String code, Object entity) {
        map.get(code).validate(entity);
    }
}
