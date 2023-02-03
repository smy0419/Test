package leetcode;

import java.util.Arrays;

public class 快速排序5 {
    public static void main(String[] args) {
//        int[] nums = {11, 24, 5, 32, 50, 34, 54, 76, 5, 1};
//        int[] nums = {4, 7, 6, 5, 3, 2, 8, 1};
        int[] nums = {5, 4, 3, 2, 1};
//        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("快速排序前:" + Arrays.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println("快速排序后:" + Arrays.toString(nums));
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivotPos = partition(a, low, high);
            quickSort(a, low, pivotPos - 1);
            quickSort(a, pivotPos + 1, high);
        }
    }

    private static int partition(int[] a, int low, int high) {
        int pivot = a[low];
        while (low < high) {
            while (low < high && a[high] >= pivot) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= pivot) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = pivot;
        return low;
    }
}
