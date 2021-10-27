import java.util.Arrays;
import java.util.BitSet;
import java.util.Random;

/**
 * 去除重复并排序
 * bitMap位图demo
 *
 * @author
 * @date
 */
public class BitMapDemo {
    final int ARR_NUM = 800;
    final int LEN_INT = 32;
    final int M_MAX = 9999;
    final int M_MIN = 1000;
    int N = M_MAX - M_MIN + 1;

    public static void main(String[] args) {
        new BitMapDemo().findDuplicate();
        new BitMapDemo().findDupJdk();
    }

    public void findDupJdk() {
        System.out.println("*******调用JDK中的库方法--开始********");
        BitSet bitArray = new BitSet(N);
        int[] array = getArray();
        for (int i = 0; i < ARR_NUM; i++) {
            bitArray.set(array[i] - M_MIN);
        }
        int count = 0;
        for (int j = 0; j < bitArray.length(); j++) {
            if (bitArray.get(j)) {
                System.out.print(j + M_MIN + " ");
                count++;
            }
        }
        System.out.println();
        System.out.println("排序后的数组大小为：" + count);
        System.out.println("*******调用JDK中的库方法--结束********");
    }

    public void findDuplicate() {
        int[] array = getArray();
        int[] bitArray = setBit(array);
        printBitArray(bitArray);
    }

    public void printBitArray(int[] bitArray) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (getBit(bitArray, i) != 0) {
                count++;
                System.out.print(i + M_MIN + "\t");
            }
        }
        System.out.println();
        System.out.println("去重排序后的数组大小为：" + count);
    }

    public int getBit(int[] bitArray, int k) {// 1右移 k % 32位 与上 数组下标为 k/32 位置的值
        return bitArray[k / LEN_INT] & (1 << (k % LEN_INT));
    }

    public int[] setBit(int[] array) {// 首先取得数组位置下标 i/32, 然后 或上
        // 在该位置int类型数值的bit位：i % 32
        int bitArrLen = N / LEN_INT + 1;
        int[] bitArray = new int[bitArrLen];
        for (int j : array) {
            int num = j - M_MIN;
            bitArray[num / LEN_INT] |= (1 << (num % LEN_INT));
        }
        return bitArray;
    }

    public int[] getArray() {
        int[] array = new int[ARR_NUM];
        System.out.println("数组大小：" + ARR_NUM);
        Random r = new Random();
        for (int i = 0; i < ARR_NUM; i++) {
            array[i] = r.nextInt(N) + M_MIN;
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
}