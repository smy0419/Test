package leetcode;

import java.util.Arrays;
import java.util.Random;

public class 快速排序7 {
    public static void main(String[] args) {
        int[] nums = {11, 24, 5, 32, 50, 34, 54, 76, 5, 1};
//        int[] nums = {4, 7, 6, 5, 3, 2, 8, 1};
//        int[] nums = {5, 4, 3, 2, 1};
//        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("快速排序前:" + Arrays.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println("快速排序后:" + Arrays.toString(nums));
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int pivot_pos = partition(arr, l, r);
        quickSort(arr, l, pivot_pos - 1);
        quickSort(arr, pivot_pos + 1, r);
    }

    /**
     * 单边循环法的partition函数
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot_pos = new Random().nextInt(high - low + 1) + low;
        swap(arr, pivot_pos, high);
        int i = low;
        int pivot = arr[high];
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
