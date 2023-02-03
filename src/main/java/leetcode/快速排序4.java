package leetcode;

import java.util.Arrays;

public class 快速排序4 {
    public static void main(String[] args) {
//        int[] nums = {11, 24, 5, 32, 50, 34, 54, 76, 5, 1};
        int[] nums = {4, 7, 6, 5, 3, 2, 8, 1};
//        int[] nums = {5, 4, 3, 2, 1};
//        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("快速排序前:" + Arrays.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println("快速排序后:" + Arrays.toString(nums));
    }

    /**
     * 快慢指针的另一种写法，取最右边为基准元素
     *
     * @param a
     * @param low
     * @param high
     */
    public static void quickSort(int[] a, int low, int high) {
        //如果一直拆分到只有一位就返回
        if (low >= high) {
            return;
        }
        //将最右边的数字作为基准值
        int pivot = a[high];
        // 慢指针i的作用是标记基准值最后应该在的位置
        int i = low - 1;
        //由快指针j一直比较到基准值的前一位
        for (int j = low; j < high; j++) {
            //如果该值小于基准值,那么就将i++,将该值,放到i的前面,也就是基准值位置的左面
            if (a[j] < pivot) {
                i++;
                //交换位置,将小的数放在左面
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
            }
        }
        //  最后将基准值放到合适的位置,也就是i的前面一位
        int tmp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = tmp;
        //递归的排列左边的部分
        quickSort(a, low, i);
        //递归的排列右边的部分
        quickSort(a, i + 2, high);
    }

}
