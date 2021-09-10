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
        String a = "hello2";
        String a1 = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        System.out.println((a == c));
        System.out.println((a == e));
        System.out.println((a == a1));
    }
}
