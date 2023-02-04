package leetcode;

public class 只出现一次的数字 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 3, 1, 7};
        System.out.println(singleNumber(nums));
        System.out.println(11 ^ 0);
    }

    private static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}
