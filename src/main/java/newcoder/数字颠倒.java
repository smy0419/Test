package newcoder;

import java.util.Scanner;

public class 数字颠倒 {
    private static String getString(int number) {
        StringBuilder s = new StringBuilder();
        if (number == 0) {
            return "0";
        }
        while (number != 0) {
            s.append(number % 10);
            number /= 10;
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        String result = getString(number);
        System.out.println(result);
    }
}
