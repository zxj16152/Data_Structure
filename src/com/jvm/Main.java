package com.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String line = in.nextLine();
//        String line = "1+2+99-10-10=";
        line += "=";
        int function = function(line);
        System.out.println(function);

    }

    public static int function(String line) {
        char[] array = line.toCharArray();
        List<Integer> nums = new ArrayList<>();
        List<Character> funs = new ArrayList<>();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= '9' && array[i] >= '0') {
                builder.append(array[i]);
            } else {
                String numSt = builder.toString();
                int num = Integer.parseInt(numSt);
                nums.add(num);
                funs.add(array[i]);
                builder = new StringBuilder();
            }
        }
        return cal(nums, funs);
    }

    public static int cal(List<Integer> nums, List<Character> funs) {
        int sum = nums.get(0);
        for (int i = 0; i < funs.size(); i++) {
            if (funs.get(i) == '+') {
                sum += nums.get(i + 1);
            } else if (funs.get(i) == '-') {
                sum -= nums.get(i + 1);
            }
        }
        return sum;
    }


}
