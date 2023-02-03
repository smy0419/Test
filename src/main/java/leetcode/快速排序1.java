package leetcode;

import java.util.Arrays;

public class 快速排序1 {
    public static void main(String[] args) {
//        int[] arry = {1, 3, 5, 2, 4, 7, 6, 7};
//        int[] arry = {1, 23, 45, 3, 4, 67, 34, 53, 56, 3, 2};
        int[] arry = {1, 2, 3, 4, 5, 6, 7};
//        QuickSort(arry, 0, arry.length - 1);
        quickSort2(arry, 0, arry.length - 1);
        System.out.println(Arrays.toString(arry));
    }

    public static void quickSort2(int[] arr, int L, int R) {
        if (L >= R) return;
        int left = L, right = R;
        int pivot = arr[left];
        while (left < right) {
            while (arr[right] >= pivot && left < right) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
                left++;
            }
            while (arr[left] <= pivot && left < right) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
                right--;
            }
            if (left == right) {
                arr[left] = pivot;
            }
        }
        quickSort2(arr, L, right - 1);
        quickSort2(arr, right + 1, R);
    }

    private static void quickSort3(int[] src, int begin, int end) {
        if (begin < end) {
            int key = src[begin];
            int i = begin;
            int j = end;
            while (i < j) {
                while (i < j && src[j] > key) {
                    j--;
                }
                if (i < j) {
                    src[i] = src[j];
                    i++;
                }
                while (i < j && src[i] < key) {
                    i++;
                }
                if (i < j) {
                    src[j] = src[i];
                    j--;
                }
            }
            src[i] = key;
            quickSort3(src, begin, i - 1);
            quickSort3(src, i + 1, end);
        }
    }

    public static void QuickSort(int[] arr, int L, int R) {
        if (L > R) return;
        int left = L, right = R;
        int pivot = arr[left];
        while (left < right) {
            while (arr[right] >= pivot && left < right) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
                left++;
            }
            while (arr[left] <= pivot && left < right) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
                right--;
            }
            if (left >= right) {
                arr[left] = pivot;
            }
        }
        QuickSort(arr, L, right - 1);
        QuickSort(arr, right + 1, R);
    }
}
