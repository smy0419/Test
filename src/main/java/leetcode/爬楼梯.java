package leetcode;

import java.util.HashMap;
import java.util.Map;

public class 爬楼梯 {
    private static Map<Integer, Integer> resultMap = new HashMap<>();

    public static void main(String[] args) {
        int n = 30;
        int result = getResult(n);
        System.out.println(result);
    }

    /**
     * 带hashmap的递归
     *
     * @param n
     * @return
     */
    public static int getResult(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (resultMap.get(n) != null) {
            return resultMap.get(n);
        }
        int result = getResult(n - 1) + getResult(n - 2);
        resultMap.put(n, result);
        return result;
    }

    public static int getResult2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int result = 0;
        int pre = 1;
        int prePre = 2;
        for (int i = 3; i <= n; i++) {
            
        }
        return result;
    }

}
