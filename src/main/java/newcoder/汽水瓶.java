package newcoder;

import java.util.Scanner;

public class 汽水瓶 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            if (number != 0) {
                System.out.println(number / 2);
            }
        }
    }
}
