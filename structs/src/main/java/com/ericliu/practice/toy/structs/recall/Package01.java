package com.ericliu.practice.toy.structs.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuhaoeric
 * Create time: 2019/07/26
 * Description:
 */
public class Package01 {

    int[] items;


    private int maxWeight;
    private int maxCount;

    private int weight = 0;
    private int count = 0;


    private int maxPrice = 0;
    private int price = 0;


    private List<Integer> list = new ArrayList<>();


    public Package01(int[] items, int maxWeight, int maxCount) {
        this.items = items;
        this.maxWeight = maxWeight;
        this.maxCount = maxCount;
    }

    public void input(int count, int weight, int price) {

        if (weight == maxWeight || count == maxCount) {
            maxPrice = Math.max(maxPrice, price);
            System.out.println("all weight is " + weight + " count is " + count + " price: " + price + " maxPrice: " + maxPrice);
            return;
        }
        input(count + 1, weight, price);
        if (weight + items[count] <= maxWeight) {
            price+=getPrice(items[count]);
            System.out.print("items["+count+"]="+items[count]+" ");
            input(count + 1, weight + items[count],price);
        }
    }

    public static void main(String[] args) {
        Package01 pkg = new Package01(new int[]{2, 2, 4, 6, 3}, 10, 4);
        pkg.input(0, 0, 0);
        System.out.println();
    }

    private int getPrice(int weight) {
        int i = 0;
        switch (weight) {
            case 2:
                i = weight * 1;
                break;
            case 3:
                i = weight * 1;
                break;
            case 4:
                i = weight * 1;
                break;
            case 6:
                i = weight * 1;
                break;
            default:
                throw new IllegalArgumentException(" not weight");
        }

        return i;
    }
}

