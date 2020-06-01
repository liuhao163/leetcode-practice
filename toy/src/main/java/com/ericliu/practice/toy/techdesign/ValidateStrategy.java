package com.ericliu.practice.toy.techdesign;

/**
 * @Author: liuhaoeric
 * Create time: 2020/06/01
 * Description:
 */
public interface ValidateStrategy {

    void validate(Object entity);

    String getCode();
}
