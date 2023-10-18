package com.solution.huawei;

import java.util.ArrayList;
import java.util.List;

public class Solution_3 {

    public static List<String> getCoordinate(String s) {
        char[] array = s.toCharArray();
        List<String> res = new ArrayList<>();
        int i = 0;
        StringBuilder builder = null;
        boolean flag = false;
        while (i < array.length) {
            if (array[i] == '(') {
                builder = new StringBuilder();
                flag = true;
            } else if (array[i] == ')') {
                res.add(builder.toString());
                flag = false;
            } else {
                if (flag) {
                    builder.append(array[i]);
                }
            }
            i++;
        }
        return res;
    }

    private static boolean isValid(String... strings) {
        for (String s : strings) {
            if (s.charAt(0) == '0') {
                return false;
            }
        }
        return true;
    }

    public static int distance(String... strings) {
        int res = 0;
        int x = Integer.parseInt(strings[0]);
        int y = Integer.parseInt(strings[1]);
        res = x * x + y * y;
        return res;
    }

    public static void main(String[] args) {
        int res = 0;
        String result = null;
        List<String> coordinates = getCoordinate("ferg(3,10)a13fdsf3(3,4)f2r3rfasf(5,10)");
        for (String coordinate : coordinates) {
            String[] splits = coordinate.split(",");
            if (isValid(splits)) {
                int distance = distance(splits);
                if (distance > res) {
                    res = distance;
                    result = new StringBuilder("(").append(coordinate).append(")").toString();
                }
            }

        }
        if (res == 0) {
            result = "(0,0)";
        }
        System.out.println(result);
    }
}
