import java.util.Arrays;

/**
 * 给定一个无序数组arrA，和一个数字K，对于arrA里面的每一个元素，
 * 加上一个随机的数字T(T的随机范围为-K<=T<=K)，得到arrB。
 * 在arrB中，最大值maxVal减去最小值minVal得到resVal。
 * 所有可能的arrB获得的resVal中，若某个resVal最小且唯一，
 * 则返回该arrB中的[minVal,maxVal]；若resVal最小时arrB不唯一，
 * 返回min[maxVal+minVal]情况下的[minVal,maxVal]。
 * [-1,9,9]的最大值-最小值为10，当K=6时，可得到的arr数组里min[最大值-最小值]=0，
 * 可以得到arrB为[4,4,4]或者为[5,5,5]，但是4+4比5+5小，所以返回[4,4]
 */
public class 转化数组 {

    public static void main(String[] args) {

    }

    public int[] tranArr(int[] arrA, int K) {
        Arrays.sort(arrA);
        int[] result = new int[2];
        int max = arrA[arrA.length - 1];
        int min = arrA[0];

        result[0] = min + K;
        result[1] = max - K;
        return result;
    }
}
