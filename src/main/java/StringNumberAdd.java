/**
 * s1:字符串类型的正整数，长度可能超过100位，
 * s2:字符串类型的正整数，长度小于s1
 * 求s1+s2的和
 */
public class StringNumberAdd {
    private static String add(String s1, String s2) {
        int lengthS1 = s1.length();
        int lengthS2 = s2.length();
        int zeroNum = lengthS1 - lengthS2;
        // 先将两个字符串对齐，便于统一处理
        StringBuilder s2Builder = new StringBuilder(s2);
        while (zeroNum > 0) {
            s2Builder.insert(0, "0");
            zeroNum--;
        }
        System.out.println(s1 + "=====" + s2Builder);

        StringBuilder resultBuilder = new StringBuilder();
        // 标记上一次循环的结果，是否需要进位
        boolean needAdd = false;
        for (int i = s1.length() - 1; i >= 0; i--) {
            String number1 = String.valueOf(s1.charAt(i));
            String number2 = String.valueOf(s2Builder.charAt(i));
            int result = Integer.parseInt(number1) + Integer.parseInt(number2);
            if (needAdd) {
                result += 1;
            }
            if (result >= 10) {
                needAdd = true;
                resultBuilder.append(result - 10);
            } else {
                needAdd = false;
                resultBuilder.append(result);
            }
        }

        return resultBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(add("666666666", "123456"));
        System.out.println(666666666 + 123456);
    }
}
