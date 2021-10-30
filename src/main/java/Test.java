import java.util.HashMap;

public class Test {
    public Test() {
        System.out.println("初始化");
    }

    public static void main(String[] args) {
        HashMap ss = new HashMap();
        ss.putIfAbsent(1, new Integer(1));
        ss.putIfAbsent(1, new Integer(2));
        System.out.println(ss.get(1));
    }
}
