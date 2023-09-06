package com.solution;

/**
 * 无符号加法
 * 异或运算得到  无进位数
 * and  运算左移得到进位信息
 */
public class NumberOperation {
    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    /**
     * 相反数，原数取反加一
     *
     * @param n
     * @return
     */
    public static int negNum(int n) {
        return add(~n, 1);
    }

    public static int muti(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) == 1) {
                res = add(res, a);
            }
            b >>>= 1;
            a <<= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(add(13, 78));
        System.out.println(muti(16, 8));
    }
}
