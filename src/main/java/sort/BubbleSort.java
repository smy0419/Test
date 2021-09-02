package sort;

/**
 * @author sunmengyuan
 * @date 2021-09-01
 * 冒泡排序
 */
public class BubbleSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int x = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
                x++;
            }
        }
        System.out.println("循环次数：" + x);
        for (int k = 0; k < nums.length; k++) {
            System.out.print(nums[k] + " ");
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1, 5, 3, 4, 2, 9, 7, 8, 6};
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(nums);
    }

}
