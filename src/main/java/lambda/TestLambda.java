package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author sunmengyuan
 * @date 2021-10-06
 */
public class TestLambda {
    public static void main(String[] args) {
        // 返回给定字符串数组中包含的不同单词
        String[] words = {"goodbye", "world"};
        List<String> xx = Arrays.stream(words)
                .map(v -> v.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        // 给定一个数字列表，返回每个数的平方构成的列表
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = numbers.stream()
                .map(v -> v * v)
                .collect(Collectors.toList());
        System.out.println(result);

        // 给定一个数字列表，返回第一个平方能被3整除的数
        Optional<Integer> x = numbers.stream()
                .filter(v -> v * v % 3 == 0)
                .findFirst();
        System.out.println(x.get());

        // 求和
        System.out.println(numbers.stream().reduce((Integer a, Integer b) -> a + b));
        System.out.println(numbers.stream().reduce((a, b) -> a + b));
        System.out.println(numbers.stream().reduce(Integer::sum));
        System.out.println(numbers.stream().reduce(0, Integer::sum));

        // 拼接字符串
        String[] s = {"zhangsan", "lisi", "wangwu"};
        // 高效，用了StringBuilder
        String concatStr = Arrays.stream(s).collect(Collectors.joining());
        // 低效，每次都new一个新的String
        String concatStr2 = Arrays.stream(s).reduce("", (s1, s2) -> s1 + s2);
        System.out.println(concatStr);
        System.out.println(concatStr2);

        // 找出最大、最小值
        System.out.println(numbers.stream().max(Comparator.comparing(Integer::intValue)));
        System.out.println(numbers.stream().min(Comparator.comparing(Integer::intValue)));

        // 生成斐波那契数列
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println(t[0] + "/" + t[1]));

    }
}
