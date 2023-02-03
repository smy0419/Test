package leetcode;

import java.util.Arrays;

/**
 * 单边循环法的快速排序，参考《漫画算法-小灰》
 */
public class 快速排序6 {
    public static void main(String[] args) {
        int[] nums = {11, 24, 5, 32, 50, 34, 54, 76, 5, 1, 1};
//        int[] nums = {4, 7, 6, 5, 3, 2, 8, 1};
//        int[] nums = {5, 4, 3, 2, 1};
//        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("快速排序前:" + Arrays.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println("快速排序后:" + Arrays.toString(nums));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot_pos = partition(arr, low, high);
        quickSort(arr, low, pivot_pos - 1);
        quickSort(arr, pivot_pos + 1, high);
    }

    /**
     * 单边循环（单边指针）法的partition函数
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int partition(int[] arr, int low, int high) {
        // mark变量表示小于pivot基准数的边界
        int mark = low;
        int pivot = arr[low];
        for (int i = low + 1; i <= high; i++) {
            // 如果当前元素小于pivot，则先将mark边界+1
            // 再将当前元素和mark指向的元素交换位置
            if (arr[i] < pivot) {
                mark++;
                int temp = arr[mark];
                arr[mark] = arr[i];
                arr[i] = temp;
            }
        }
        // 这里先mark指针指向的元素先放在pivot所在的位置，腾出一个空位，这里因为开始时pivot在arr[low]
        arr[low] = arr[mark];
        // 然后再将pivot基准元素放在mark指针所在的位置
        arr[mark] = pivot;
        return mark;
    }
}
