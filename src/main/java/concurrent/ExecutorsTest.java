package concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorsTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(null, 1);
        hashMap.put(null, 2);
        hashMap.put(null, null);

        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(null, 1);
        concurrentHashMap.put(1, null);
        System.out.println(hashMap.get(null));
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(executorService);
        AtomicInteger atomicInteger = new AtomicInteger(1);
        Future<AtomicInteger> future = executorService.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicInteger.set(111);
        }, atomicInteger);
        System.out.println(future.get(999, TimeUnit.MILLISECONDS));
    }


}
