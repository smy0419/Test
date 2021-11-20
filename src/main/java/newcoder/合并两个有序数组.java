package newcoder;

import java.util.Arrays;

public class 合并两个有序数组 {
    public static void main(String[] args) {
        int[] a = new int[5];
        a[0] = 1;
        a[1] = 3;
        int[] b = {2, 4, 6};
        merge(a, 2, b, 3);
        Arrays.stream(a).forEach(v -> System.out.println(v));
    }

    public static void merge(int[] a, int m, int[] b, int n) {
        // 合并
        for (int i = 0; i != n; i++) {
            a[m + i] = b[i];
        }
        Arrays.sort(a);
    }
}
