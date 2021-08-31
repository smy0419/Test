/**
 * @author sunmengyuan
 * @date 2021-08-31
 * 给定一个升序整数数组及一个目标正整数，如果数组中有两个数字之和刚好等于目标数，返回这两个数字的索引
 */
public class TwoSum {
    private static int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 5, 8, 11, 23};
        int[] result = twoSum(nums, 1);
        System.out.println(result[0] + " " + result[1]);
    }
}
