package leetcode;

import java.util.Arrays;

public class 快速排序1 {
    public static void main(String[] args) {
//        int[] arry = {1, 3, 5, 2, 4, 7, 6, 7};
        int[] arry = {2, 23, 45, 3, 1, 67, 34, 53, 56, 3, 2};
//        int[] arry = {1, 2, 3, 3, 4, 5, 6, 7};
//        QuickSort(arry, 0, arry.length - 1);
        quickSort(arry, 0, arry.length - 1);
        System.out.println(Arrays.toString(arry));
    }

    /**
     * 双边循环法
     *
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = arr[low];
        int left = low, right = high;
        while (left != right) {
            while (left < right && arr[right] > pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            // 交换left和right指针所指向的元素
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        arr[low] = arr[left];
        arr[left] = pivot;
        quickSort(arr, low, right - 1);
        quickSort(arr, right + 1, high);
    }

}
