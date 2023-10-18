package com.solution;


import java.util.ArrayList;
import java.util.List;

public class SolutionCMB {

    public String maxDictionaryOrder(String s) {
        // write code here
        char[] array = s.toCharArray();
        int index = 0;
        List<Character> result = new ArrayList<>();
        dp(array, 0, result);

        StringBuilder builder = new StringBuilder();
        for (Character character : result) {
            builder.append(character);
        }
        return builder.toString();
    }

    public void dp(char[] array, int index, List<Character> result) {
        if (index == array.length) {
            return;
        }
        char max = array[index];
        for (int i = index; i < array.length; i++) {
            if (array[i] < max) {

            } else if (array[i] > max) {
                System.out.println(index);
                index = i;
                max = array[i];
            }
        }
        result.add(max);
        dp(array, index + 1, result);
    }

    public static void main(String[] args) {
        String s = "cmbchina";
//        String b = maxDictionaryOrder(s);
//        System.out.println(b);
    }
}
