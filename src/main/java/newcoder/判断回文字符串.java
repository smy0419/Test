package newcoder;

/**
 * 给定一个长度为 n 的字符串，请编写一个函数判断该字符串是否回文。如果是回文请返回true，否则返回false。
 * <p>
 * 字符串回文指该字符串正序与其逆序逐字符一致。
 * <p>
 * 数据范围：0 < n ≤1000000
 * 要求：空间复杂度 O(1)，时间复杂度 O(n)
 */
public class 判断回文字符串 {

    public static void main(String[] args) {
        System.out.println(judge("abcba"));
    }

    static boolean judge2(String str) {
        String rev = new StringBuffer(str).reverse().toString();
        return str.equals(rev);
    }

    static boolean judge(String str) {
        // 判断特殊情况
        if (str == null || str.length() == 0) {
            return false;
        }
        // 定义双指针，不相同则不是回文串
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
