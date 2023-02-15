package leetcode;

public class 删除数组中的重复项 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 3, 4};
        System.out.println(deleteDuplicate(nums));
    }

    public static int deleteDuplicate(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
