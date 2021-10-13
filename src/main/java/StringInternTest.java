public class StringInternTest {
    public static void main(String[] args) {
        String s3 = new StringBuilder("jax").append("va").toString();
        // true
        System.out.println(s3.intern() == s3);

        String s4 = new StringBuilder("ja").append("va").toString();
        // false
        System.out.println(s4.intern() == s4);


        String s5 = "java";
        // true
        System.out.println(s5.intern() == s5);

        String s6 = new String("java");
        // false
        System.out.println(s6.intern() == s6);

        String s7 = new StringBuilder("计算机").append("软件").toString();
        // true
        System.out.println(s7.intern() == s7);
    }
}
