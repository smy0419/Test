/**
 * @author sunmengyuan
 * @date 2021-09-10
 * 对于一个final变量，如果是基本数据类型的变量，则其数值一旦在初始化之后便不能更改；如果是引用类型的变量，则在对其初始化之后便不能再让其指向另一个对象。
 * 引用变量被final修饰之后，虽然不能再指向其他对象，但是它指向的对象的内容是可变的
 */
public class FinalDemo {
    public static void main(String[] args) {
        /**
         * 当final变量是基本数据类型以及String类型时，如果在编译期间能知道它的确切值，则编译器会把它当做编译期常量使用。
         * 也就是说在用到该final变量的地方，相当于直接访问的这个常量，不需要在运行时确定。
         */
        // 会放在常量池中，位于方法区/metaspace
        String a = "hello2";
        // 因为在常量池中已经有hello2,所以a1与a指向同一个对象
        String a1 = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        System.out.println((a == c));
        System.out.println((a == e));
        System.out.println((a == a1));

        /**
         * 面试题：String str4 = new String(“abc”) 创建多少个对象？
         * 在常量池中查找是否有“abc”对象
         * 有则返回对应的引用实例
         * 没有则创建对应的实例对象
         * 在堆中 new 一个 String("abc") 对象
         * 将对象地址赋值给str4,创建一个引用
         * 所以，常量池中没有“abc”字面量则创建两个对象，否则创建一个对象，以及创建一个引用
         * 根据字面量，往往会提出这样的变式题：
         * String str1 = new String("A"+"B") ; 会创建多少个对象?
         * String str2 = new String("ABC") + "ABC" ; 会创建多少个对象?
         * str1：
         * 字符串常量池："A","B","AB" : 3个
         * 堆：new String("AB") ：1个
         * 引用： str1 ：1个
         * 总共 ： 5个
         * str2 ：
         * 字符串常量池："ABC" : 1个
         * 堆：new String("ABC") ：1个
         * 引用： str2 ：1个
         * 总共 ： 3个
         */
    }
}
