package concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 这个代码演示了jdk8 ConcurrentHashMap的bug导致的死循环问题
 */
public class ConcurrentHashMapBugTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new ConcurrentHashMap<>(16);
        map.computeIfAbsent("AaAa",
                key -> map.computeIfAbsent("BBBB", key2 -> 42)
        );

        System.out.println("方法结束 map=" + map);
    }
}
