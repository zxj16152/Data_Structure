package com.solution;


import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Date 2023/8/10 10:06
 * @Created by ZHOUXINJIAN3
 */
public class Solution43 {
    public String multiply(String num1, String num2) {
        List<Integer> list = new ArrayList<Integer>();
        int l1 = num1.length();
        int l2 = num2.length();
        int targetLen = l1 + l2;
        int[] target = new int[targetLen];
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        for (int j = l2 - 1; j >= 0; j--) {
            int bj = (l2 - 1) - j;
            for (int i = l1 - 1; i >= 0; i--) {
                int bi = (l1 - 1) - i;
                int mul = (chars1[i] - '0') * (chars2[j] - '0');
                int v = mul % 10;
                target[bi + bj] += v;
                if (target[bi + bj] >= 10) {
                    int temp = target[bi + bj];
                    target[bi + bj] = target[bi + bj] % 10;
                    target[bi + bj + 1] = target[bi + bj + 1] + (temp / 10);
                }
                if (mul >= 10) {
                    target[bi + bj + 1] += (mul / 10);

                }
            }

        }
        String res = "";
        int k = 0;
        for (int i = targetLen - 1; i >= 0; i--) {
            if (target[i] != 0) {
                k = i;
                break;
            }
        }
        for (int i = k; i >= 0; i--) {
            res += target[i];
        }
        return res;

    }


    public String multiply2(String num1, String num2) {
        int[] target = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                target[p1] += mul / 10;
                target[p2] += mul % 10;
            }
        }
        for (int i = target.length - 1; i > 0; i--) {
            if (target[i] >= 10) {
                int temp = target[i];
                target[i] = temp % 10;
                target[i - 1] += temp / 10;
            }
        }
        int k = -1;
        for (int i = 0; i < target.length; i++) {
            if (target[i] != 0) {
                k = i;
                break;
            }
        }
        if (k == -1) {
            return "0";
        }
        String res = "";
        for (int i = k; i < target.length; i++) {
            res += target[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution43 solution = new Solution43();
        String multiply = solution.multiply2("0", "0");
        System.out.println(multiply);
        System.out.println(123 * 456);
    }
}
