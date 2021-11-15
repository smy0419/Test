package newcoder;

import java.util.Scanner;

public class 单词倒排 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] sp = in.nextLine().split("[^a-zA-Z]+");
        StringBuilder sb = new StringBuilder();
        for (int i = sp.length - 1; i >= 0; i--) {
            sb.append(sp[i] + " ");
        }
        System.out.println(sb.toString().trim());
    }
}
