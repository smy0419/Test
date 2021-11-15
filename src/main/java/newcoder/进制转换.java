package newcoder;


import java.util.Scanner;

public class 进制转换 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(Integer.valueOf(str.substring(2), 16));
        }
    }
}
