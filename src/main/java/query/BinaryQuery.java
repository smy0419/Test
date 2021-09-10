package query;

import java.util.Arrays;

/**
 * @author sunmengyuan
 * @date 2021-09-03
 * 二分查找算法
 * 二分查找算法适用于已经排序的数据
 */
public class BinaryQuery {
    public static int query(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 99, 22, 11, 23, 5, 78, 9898, 11, 323, 434, 454, 68, 432, 789, 33, 65};
        System.out.println(query(nums, 9898));
    }
}
