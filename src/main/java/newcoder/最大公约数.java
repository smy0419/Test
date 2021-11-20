package newcoder;

/**
 * 我们用辗转相除法（又称欧几里得算法）来计算两个数的最大公约数 (Greatest Common Divisor)所以下文用gcd(a,b)表示a和b的最大公约数。
 * <p>
 * 先举一个例子：
 * 假如需要求 434 和 652 的最大公约数,用欧几里得算法，是这样进行的：
 * 434 / 652 = 0 (余 434)
 * 652 / 434 = 1(余218)
 * 434 / 218 = 216(余2)
 * 218 / 2 = 109 (余0)
 * 以除数和余数反复做除法运算，当余数为 0 时，取当前算式除数为最大公约数，所以就得出了 434 和 652 的最大公约数 2。
 */
public class 最大公约数 {
    public static void main(String[] args) {
        int a = 8;
        int b = 12;
        System.out.println(gcb(a, b));
    }

    static int gcb(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcb(b, a % b);
        }
    }
}
