/**
 * @author sunmengyuan
 * @date 2021-10-36
 * 此示例用来演示ReentrantReadWriteLock中一些字段的定义
 */
public class IntegerBinaryStr {
    public static void main(String[] args) {
        // 16是常量，将int字段的32位拆成了2半
        // 读锁单位值65536
        int shared_unit = 1 << 16;
        // 读锁或者写锁最大可重入次数65535
        int max_count = (1 << 16) - 1;
        // 写锁的掩码，二进制是16个1
        int exclusive_mask = (1 << 16) - 1;
        // c表示state字段的值
        int c = Integer.parseInt("00000000000000010000000000000000", 2);
        System.out.println(shared_unit + "二进制=" + Integer.toBinaryString(shared_unit));
        System.out.println(max_count + "二进制=" + Integer.toBinaryString(max_count));
        System.out.println(exclusive_mask + "二进制=" + Integer.toBinaryString(exclusive_mask));
        System.out.println(c);
        System.out.println(c & exclusive_mask);
        System.out.println("读锁线程数" + (c >>> 16));
    }
}
