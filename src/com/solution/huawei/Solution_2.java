package com.solution.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 给定一个输入字符串，字符串只可能由英文字母(a'~2、AZ 和左右小括号((、组成。当字符里存在小括号时小括号是成对的，可以有一个或多个小括号对，小括号对不会嵌套，
 * 小括号对内可以包含1个或多个英文字母，也可以不包含英文字母。
 * 当小括号对内包含多个英文字母时，这些字母之间是相互等效的关系，而且等效关系可以在不同的小括号对之间传递，即当存在a和b等效和存在b和C" 等效时，" 和 也等效，
 * 另外，同一个英文字母的大写字母和小写字母也相互等效(即使它们分布在不同的括号对里)
 * 需要对这个输入字符串做简化，输出一个新的字符串，输出字符串里只需保留输入字符串里的没有被小括号对包含的字符(按照输入字符串里的字符顺序)，
 * 并将每个字符替换为在小括号对里包含且字典序最小的等效字符。如果简化后的字符串为空，请输出为"0”。
 * 示例:
 * 输入字符串为"never(dontgive(run)up((”，初始等效字符集合为(d,o,n,t)、(r,u,n)，由于等效关系可以传递，因此最终等效字符集合为(d,o,n,t,r,u)，
 * 将输入字符串里的剩余部分按字典序最小的等效字符替换后得
 * 到"devedgivedp"。
 */
public class Solution_2 {
    public static TreeSet<Integer> getEqChar(String originString) {
        TreeSet<Integer> set = new TreeSet<>();
        if (originString.length() <= 1) {
            return set;
        }
        List<String> list = new ArrayList<>();
        char[] chars = originString.toCharArray();

        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                flag = true;
                continue;
            }
            if (chars[i] == ')') {
                flag = false;
                continue;
            }
            if (flag) {
                set.add((int) chars[i]);
                list.add(Character.toString(chars[i]));
            }
        }
        System.out.println(list);

        return set;
    }

    public static String simplifyString(String originString) {
        TreeSet<Integer> eqCharSet = getEqChar(originString);
        Character first = null;
        if (!eqCharSet.isEmpty()) {
            first = (char) eqCharSet.first().intValue();
        }
        boolean flag = false;
        char[] chars = originString.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                flag = true;
                continue;
            }
            if (chars[i] == ')') {
                flag = false;
                continue;
            }
            if (!flag) {
                char ch = chars[i];
                if (eqCharSet.contains((ch + 32)) || eqCharSet.contains(ch - 32) || eqCharSet.contains((int) ch)) {
                    if (first < chars[i]) {
                        builder.append(first);
                    }
                } else {
                    builder.append(chars[i]);

                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
//        [d, o, n, t, r, u, n, f]
        String s = "()abcdefgaAc(a)(Ab)(C)";
//        aemanaaor
        String s1 = simplifyString(s);
        System.out.println(s1);
//        dnevedr give  dup
//        deved  givedp
    }
}
