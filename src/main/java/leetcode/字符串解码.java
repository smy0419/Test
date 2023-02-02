package leetcode;

import java.util.Stack;

/**
 * leetcode 394
 */
public class 字符串解码 {
    public static void main(String[] args) {
        String test = "13[a]2[bc]";
        String res = decodeString(test);
        System.out.println(res);
    }

    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        String res = "";
        int idx = 0;
        while (idx < s.length()) {
            char curr = s.charAt(idx);
            // 数字有可能是两位数
            if (Character.isDigit(curr)) {
                StringBuilder ret = new StringBuilder();
                while (Character.isDigit(s.charAt(idx))) {
                    ret.append(s.charAt(idx++));
                }
                countStack.push(Integer.parseInt(ret.toString()));
            } else if (curr == '[') {
                resStack.push(res);
                res = "";
                idx++;
            } else if (curr == ']') {
                StringBuilder temp = new StringBuilder(resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            } else {
                res += s.charAt(idx++);
            }
        }

        return res;
    }
}
