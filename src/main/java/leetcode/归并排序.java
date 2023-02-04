package leetcode;

import java.util.Arrays;

public class 归并排序 {
    public static void main(String[] args) {
        int[] arry = {2, 23, 45, 3, 1, 67, 34, 53, 56, 3, 2};
//        int[] arry = {5, 4, 3, 2, 1};
//        int[] arry = {1, 2, 3, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(mergeSort(arry)));
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    /**
     * 合并两个有序数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, array1Index = 0, array2Index = 0; index < result.length; index++) {
            if (array1Index >= left.length) {
                result[index] = right[array2Index++];
            } else if (array2Index >= right.length) {
                result[index] = left[array1Index++];
            } else if (left[array1Index] < right[array2Index]) {
                result[index] = left[array1Index++];
            } else {
                result[index] = right[array2Index++];
            }
        }
        return result;
    }
}
