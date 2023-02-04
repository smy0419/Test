package leetcode;

import java.util.Arrays;

public class 堆排序 {
    public static void main(String[] args) {
        int[] arr = {2, 23, 45, 3, 1, 67, 34, 53, 56, 3, 2};
//        int[] arr = {5, 4, 3, 2, 1};
//        int[] arr = {1, 2, 3, 3, 4, 5, 6, 7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        int i;
        int length = arr.length;
        // 建堆，自下向上
        for (i = length / 2 - 1; i >= 0; i--) {
            heapify(arr, length, i);
        }
        // 排序：将堆顶的元素和最后一个元素进行交换，然后再调用heapify维护堆的性质
        for (i = length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }


    /**
     * 维护堆的性质
     *
     * @param arr 存储堆的数组
     * @param n   数组长度
     * @param i   待维护的节点的下标
     */
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        // 找出根节点、左孩子、右孩子中最大的元素
        if (leftChild < n && arr[largest] < arr[leftChild]) {
            largest = leftChild;
        }
        if (rightChild < n && arr[largest] < arr[rightChild]) {
            largest = rightChild;
        }
        // largest != i 说明需要交换根节点和左右孩子的位置
        if (largest != i) {
            swap(arr, largest, i);
            // 交换完成之后需要重新检查largest位置的节点是否满足堆的性质
            heapify(arr, n, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
