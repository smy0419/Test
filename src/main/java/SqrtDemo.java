/**
 * @author sunmengyuan
 * @date 2021-08-31
 * 已知sqrt(2)约等于1.414，要求不用数学库，求sqrt(2)精确到小数点后10位
 */
public class SqrtDemo {
    private static double EPSILON = 0.0000000001;

    static double sqrt2() {
        double low = 1.4, high = 1.5;
        double mid = (low + high) / 2;

        while (high - low > EPSILON) {
            if (mid * mid > 2) {
                high = mid;
            } else {
                low = mid;
            }
            mid = (high + low) / 2;
        }

        return mid;
    }

    public static void main(String[] args) {
        System.out.println(sqrt2());
    }

}
