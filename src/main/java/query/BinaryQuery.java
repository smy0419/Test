package query;

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
        int[] nums = {1, 5, 11, 22, 23, 33, 65, 68, 78, 99, 323, 432, 434, 454, 789, 9898};
        System.out.println(query(nums, 22));
    }
}
