/**
 * @author sunmengyuan
 * @date 2021-09-26
 * 斐波那契数列
 */
public class Fib {
    /**
     * 高效的dp数组算法，时间复杂度O(n)
     *
     * @param n
     * @return
     */
    static int fib(int n) {
        if (n == 2 || n == 1) {
            return 1;
        }
        int prev = 1, curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }

    /**
     * 低效的递归算法，存在大量的重复计算，时间复杂度O(2^n)
     *
     * @param n
     * @return
     */
    static int fib2(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fib2(n - 1) + fib2(n - 2);
        }
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        int result = fib(30);
        long end = System.currentTimeMillis();
        System.out.println("cost " + (end - begin) + " ms");
        System.out.println(result);
    }
}
