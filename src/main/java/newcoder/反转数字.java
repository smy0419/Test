package newcoder;

public class 反转数字 {
    public static void main(String[] args) {
        int x = 123414;
        System.out.println(reverse(x));
        System.out.println(123 / 10);
    }

    static int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }
}
