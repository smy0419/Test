package leetcode;

import java.util.Arrays;

/**
 * 快慢指针法
 */
public class 快速排序3 {
    public static void main(String[] args) {
        int[] nums = {11, 24, 5, 32, 50, 34, 54, 76, 5, 1};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 取最左边的数为key，定义两个快慢指针，都从key的下一位往右走，
     * fast每走一步判断一下它指向的元素是否小于key，
     * 若小于则交换fast和slow位置的元素，并且让slow向前走，直到fast走到底，结束循环。
     * 最后让slow和key位置的值交换。再返回key的位置。
     */
    private static void quickSort(int[] array, int low, int high) {
        int pivot, p_pos, i, temp;
        if (low < high) {
            p_pos = low;
            pivot = array[p_pos];
            for (i = low + 1; i <= high; i++) {
                if (array[i] <= pivot) {
                    p_pos++;
                    temp = array[p_pos];
                    array[p_pos] = array[i];
                    array[i] = temp;
                }
            }
            temp = array[low];
            array[low] = array[p_pos];
            array[p_pos] = temp;
            quickSort(array, low, p_pos - 1);
            quickSort(array, p_pos + 1, high);
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
