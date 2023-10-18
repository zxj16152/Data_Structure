package com.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 从字符串中找出数字
 */
public class SolutionCmb2 {

    public List<Integer> extraNum(String s) {
        // write code here
        List<List<Character>> result = new ArrayList<>();
        char[] array = s.toCharArray();
        boolean flag = false;
        List<Character> characters = null;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= '9' && array[i] >= '0') {
                if (!flag) {
                    characters = new ArrayList<>();
                    result.add(characters);
                }
                characters.add(array[i]);
                flag = true;
            } else {
                flag = false;
            }
        }
        List<Integer> integers = list2String(result);
        return integers;

    }

    public static List<Integer> list2String(List<List<Character>> result) {
        ArrayList<Integer> list = new ArrayList<>();
        for (List<Character> characters : result) {
            StringBuilder builder = new StringBuilder();
            for (Character character : characters) {
                builder.append(character);
            }
            list.add(Integer.parseInt(builder.toString()));
        }
        return list;
    }


    public static void main(String[] args) throws InterruptedException {

        SolutionCmb2 s = new SolutionCmb2();
        List<Integer> integers = s.extraNum("c12m23b3n4t56");
        System.out.println(integers);
        Thread.sleep(1000000);
    }
}
