package leetcode;

public class 字符串相加 {
    public static void main(String[] args) {
        String num1 = "12345";
        String num2 = "4554654";
        System.out.println(addString(num1, num2));
        System.out.println(Integer.parseInt(num1) + Integer.parseInt(num2));
    }

    private static String addString(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y) > 10 ? 1 : 0;
        }
        return sb.reverse().toString();
    }
}
