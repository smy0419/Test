package leetcode;

import java.util.Arrays;

public class 比特位计数 {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(Arrays.toString(countBits1(num)));
        System.out.println(Arrays.toString(countBits2(num)));
    }

    /**
     * 利用X&(X-1)可以可以消除最低位的1的特性计算1的个数
     *
     * @param num
     * @return
     */
    public static int[] countBits1(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }

    /**
     * 利用奇数和偶数的特性求1的个数
     *
     * @param num
     * @return
     */
    public static int[] countBits2(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = (i & 1) == 1 ? bits[i - 1] + 1 : bits[i >> 1];
        }
        return bits;
    }
}
