package sort;

import java.util.Objects;

/**
 * @author sunmengyuan
 * @date 2021-09-02
 * 插入排序
 */
public class InsertSort {
    public static void sort(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 2) {
            return;
        }

        int j;
        for (int i = 1; i < nums.length; i++) {
            int currentNum = nums[i];
            for (j = i - 1; j >= 0 && nums[j] > currentNum; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = currentNum;
        }

        for (int k = 0; k < nums.length; k++) {
            System.out.print(nums[k] + " ");
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1, 5, 3, 4, 2, 9, 7, 8, 6};
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1};
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        sort(nums);
    }
}
