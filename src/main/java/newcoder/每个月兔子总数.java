package newcoder;

import java.util.Scanner;

public class 每个月兔子总数 {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            System.out.println(fib(number));
        }
    }
}
