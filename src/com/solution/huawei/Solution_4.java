package com.solution.huawei;

/**
 * 小明在玩一个数字加减游戏，只使用加法或者减法，将一个数字 s 李成数字t。
 * 每个回合，小明可以用当前的数字加上或减去一个数字。
 * 现在有两种数字可以用来加减，分别为 a,b (a不等于b)，
 * 其中 b 没有使用次数限制。
 * 请问小明最少可以用多少次 a，才能将数字 s 变成数字t。题目保证数字 s 一定能变成数字t
 */
public class Solution_4 {

    public static int minNum(int s, int t, int a, int b) {
        int z = t - s;
        for (int x = 0; x < 10000; x++) {
            if ((0 - z) - x * a > 0 && ((0 - z) - x * a) % b == 0) {
                return x;
            } else if (z - x * a > 0 && (z - x * a) % b == 0) {
                return x;
            }
            if ((x * a + z) > 0 && (x * a + z) % b == 0) {
                return x;
            } else if ((x * a - z) > 0 && (x * a - z) % b == 0) {
                return x;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int i = minNum(11, 33, 4, 10);

        //  X|a|+Y|b|=|t-s｜;   求X最小值
        System.out.println(i);
    }
}
