import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;
import java.util.function.Supplier;

import static java.util.Comparator.comparing;

public class TestLambdaFinal {
    public static void main(String[] args) {
        List<Apple> apples = Lists.newArrayList();
        apples.sort(comparing(Apple::getWeight));
        Supplier<Apple> c = Apple::new;
        Apple a = c.get();
    }

    @Data
    static class Apple {
        private int weight;
    }
}
