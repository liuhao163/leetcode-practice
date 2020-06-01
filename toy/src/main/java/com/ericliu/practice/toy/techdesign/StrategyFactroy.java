package com.ericliu.practice.toy.techdesign;

/**
 * @Author: liuhaoeric
 * Create time: 2020/06/01
 * Description:
 */
public interface StrategyFactroy {

    void register(String code, ValidateStrategy strategy);

    void validateByCode(String code, Object entity);
}
