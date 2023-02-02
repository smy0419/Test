package newcoder;


public class 进制转换 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String str = scanner.nextLine();
//            System.out.println(String.valueOf(Integer.valueOf(str.substring(2), 16)));
//        }

        System.out.println(solve(7, 2));
    }

    public static String solve(int M, int N) {
        return Integer.toString(M, N);
//        Integer x = Integer.valueOf("7", N);
//        System.out.println(x);
//        return String.valueOf(Integer.valueOf(String.valueOf(M), N));
    }

}
