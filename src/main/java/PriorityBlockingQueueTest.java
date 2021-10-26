import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 优先级队列的测试demo
 * 默认情况下，poll总会输出compareTo最小的元素，可以通过在构造方法中指定一个比较器
 * 来实现自定义的排序功能，本demo使用了lambda表达式
 *
 * @author sunmengyuan
 * @date 2021-10-26
 */
public class PriorityBlockingQueueTest {
    public static void main(String[] args) {
        PriorityBlockingQueue<Integer> pbq = new PriorityBlockingQueue<>(11, (o1, o2) -> o2 - o1);

        pbq.offer(8);
        pbq.offer(67);
        pbq.offer(56);
        pbq.offer(123);
        // 加超时时间是没用的
        pbq.offer(1, 1, TimeUnit.HOURS);
        pbq.offer(3, 1, TimeUnit.HOURS);
        // 输出最大的123
        System.out.println(pbq.poll());
    }
}
