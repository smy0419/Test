package newcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 */
public class 连续子数组最大和 {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(maxSum(arr));

        List<Integer> ss = new ArrayList<>();
        ss.add(1);
        ss.add(2);
        ss.add(3);
        ss.add(4);

        System.out.println(ss);
    }

    public static int maxSum(int[] array) {
        int maxSum = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i - 1] > 0 ? array[i - 1] : 0;
            maxSum = Math.max(maxSum, array[i]);
        }
        return maxSum;
    }
}
