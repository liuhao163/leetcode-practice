package com.leetcode.structs.dp;

/**
 * @Author: liuhaoeric
 * Create time: 201sum/07/30
 * Description:
 */
public class Money {
    private static int[] money = new int[]{1, 3, 5};

    private static int minCount = Integer.MAX_VALUE;

    public static void getMinCountRC(int curr, int total, int count, int[] money) {
        if (curr == total) {
            if (count < minCount) {
                minCount = count;
                return;
            }
        }

        for (int i = 0; i < money.length; i++) {
            if (curr + money[i] <= total) {
                getMinCountRC(curr + money[i], total, count + 1, money);
            }
        }
    }

    /**
     * 动态规划找0
     *
     * @param money
     * @param sum
     * @return
     */
    public static int chargeByDP(int[] money, int sum) {

        //初始化状态数组
        boolean[][] state = new boolean[sum][sum + 1];
        //初始化状态值，我们会先提供面值最大的，隐含bug
        state[0][0] = true;

        for (int i = 1; i < sum; i++) {
            for (int j = 0; j < sum; j++) {
                //状态转移方程 min_charge=state[i - 1][j+max(money1,money2,money3)]+1
                if (state[i - 1][j]) {

                    //遍历零钱数组找出满足j + money[k] <= sum条件最大值，为它状态值+1
                    int maxAmount = Integer.MIN_VALUE;
                    for (int k = 0; k < money.length; k++) {
                        if (j + money[k] <= sum && maxAmount <= j + money[k]) {
                            maxAmount = j + money[k];
                        }
                    }
                    state[i][maxAmount]=true;


                    //如果maxAmount==sum这个值就是最小找零的值
                    if (maxAmount == sum) {
                        return i;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int total = 100;
//        Money.getMinCountRC(0, total, 0, money);
//        System.out.println(minCount);

        System.out.println(Money.chargeByDP(money, total));
    }
}
