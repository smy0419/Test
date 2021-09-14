/**
 * @author sunmengyuan
 * @date 2021-09-10
 */
public class FinalDemo2 {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        final StringBuffer buffer = new StringBuffer("hello");
        myClass.changeValue(buffer);
        System.out.println(buffer.toString());
    }
}

/**
 * 修改buffer的引用，无效
 */
//class MyClass {
//    void changeValue(StringBuffer buffer) {
//        buffer = new StringBuffer("sd");
//        buffer.append("world");
//    }
//}

/**
 * 没有修改buffer的引用，修改buffer的内容，有效
 */
class MyClass {
    void changeValue(StringBuffer buffer) {
        buffer.append("world");
    }
}