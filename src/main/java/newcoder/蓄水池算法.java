package newcoder;

import java.util.Arrays;
import java.util.Random;

/**
 * 蓄水池算法用于解决输入的序列长度未知或者长度太大无法全部加载到内存，需要随机选取m个元素，并且要保证每个元素被选取的概率相等
 */
public class 蓄水池算法 {
    public static int[] getReservoir(int[] dataStream, int m) {
        int[] reservoir = new int[m];

        for (int i = 0; i < reservoir.length; i++) {
            reservoir[i] = dataStream[i];
        }
        for (int i = m; i < dataStream.length; i++) {
            // 随机获得一个[0, i]内的随机整数
            int d = new Random().nextInt(i + 1);
            // 如果随机整数落在[0, m-1]范围内，则替换蓄水池中的元素
            if (d < m) {
                reservoir[d] = dataStream[i];
            }
        }
        return reservoir;
    }

    public static void main(String[] args) {
        int[] dataStream = {1, 2, 33, 44, 5, 6, 71, 72, 8, 93, 9, 10, 202, 12, 81, 4556, 889, 909, 11};
        int m = 3;
        int[] result = getReservoir(dataStream, m);
        Arrays.stream(result).forEach(v -> System.out.println(v));
    }

}

