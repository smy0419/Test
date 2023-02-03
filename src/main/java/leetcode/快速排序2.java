package leetcode;

import java.util.Arrays;

public class 快速排序2 {
    public static void main(String[] args) {
        int[] nums = {11, 24, 5, 32, 50, 34, 54, 76, 5, 1};
        System.out.println("快速排序前:" + Arrays.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println("快速排序后:" + Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int L, int R) {
        if (L >= R) {
            return;
        }
        int pivot = nums[L];
        int left = L;
        int right = R;
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        swap(nums, L, left);
        quickSort(nums, L, right - 1);
        quickSort(nums, right + 1, R);
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}


