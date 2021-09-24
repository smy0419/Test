/**
 * @author sunmengyuan
 * @date 2021-09-24
 */
public class TestString {
    public static void main(String[] args) {
        String a = "aaa";// 常量池
        String b = new String("aaa");// 堆内存
        String c = new String("aaa");// 堆内存
        String d = "aaa";// 常量池
        System.out.println(a == b);
        System.out.println(c == b);
        System.out.println(a == d);
    }
}
