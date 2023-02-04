package leetcode;

import java.util.Arrays;

public class 堆排序2 {
    public static void main(String[] args) {
        int[] arr = {2, 23, 45, 3, 1, 67, 34, 53, 56, 3, 2};
//        int[] arr = {5, 4, 3, 2, 1};
//        int[] arr = {1, 2, 3, 3, 4, 5, 6, 7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        int i;
        int len = arr.length;
        for (i = len / 2 - 1; i >= 0; i--) {
            adjustment(arr, i, len);
        }
        for (i = len - 1; i >= 0; i--) {
            swap(arr, 0, i);
            adjustment(arr, 0, i);
        }
    }

    public static void adjustment(int[] arr, int pos, int len) {
        int child = 2 * pos + 1;
        if (child + 1 < len && arr[child] < arr[child + 1]) {
            child++;
        }
        if (child < len && arr[pos] < arr[child]) {
            swap(arr, pos, child);
            adjustment(arr, child, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
