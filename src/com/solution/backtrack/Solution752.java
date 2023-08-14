package com.solution.backtrack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @Description
 * @Date 2023/8/9 10:56
 * @Created by ZHOUXINJIAN3
 */
public class Solution752 {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<String>();
        for (String deadend : deadends) {
            deads.add(deadend);
        }
        LinkedList<String> q = new LinkedList<>();
        Set<String> visit = new HashSet<>();
        q.offer("0000");
        visit.add("0000");
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (deads.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visit.contains(up)) {
                        q.add(up);
                        visit.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visit.contains(down)) {
                        q.add(down);
                        visit.add(down);
                    }
                }

            }
            step++;
        }
        return -1;
    }


    public int openLock2(String[] deadends, String target) {
        Set<String> deads = new HashSet<String>();
        for (String deadend : deadends) {
            deads.add(deadend);
        }
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visit = new HashSet<>();
        q1.add("0000");
        visit.add("0000");
        q2.add(target);

        int step = 0;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for (String cur : q1) {
                if (deads.contains(cur)) {
                    continue;
                }
                if (q2.contains(cur)) {
                    return step;
                }
                visit.add(cur);
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    String down = minusOne(cur, j);
                    if (!visit.contains(up)) {
                        temp.add(up);
                    }
                    if (!visit.contains(down)) {
                        temp.add(down);
                    }
                }
            }
            step++;
            q1 = q2;
            q2 = temp;
        }
        return -1;

    }

    public String plusOne(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '9') {
            chars[j] = '0';
        } else {
            chars[j] += 1;
        }
        return new String(chars);
    }

    public String minusOne(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '0') {
            chars[j] = '9';
        } else {
            chars[j] -= 1;
        }
        return new String(chars);
    }
}
