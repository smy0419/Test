import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock结合Condition实现的生产者消费者示例
 *
 * @author sunmengyuan
 * @date 2021-10-24
 */
public class ConsumerAndProducer {
    private static ReentrantLock lock = new ReentrantLock();
    static Condition notFull = lock.newCondition();
    static Condition notEmpty = lock.newCondition();
    static private Queue<String> queue = new LinkedBlockingQueue<>();
    static int maxSize = 10;

    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == 0) {
                        System.out.println("队列空了，我得等一会了。。。");
                        notEmpty.await();
                    }
                    Thread.sleep(new Random().nextInt(1000));
                    String s = queue.poll();
                    System.out.println("消费一个对象" + s);
                    notFull.signal();
                } catch (InterruptedException e) {

                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == maxSize) {
                        System.out.println("队列满了，我得等一会了。。。");
                        notFull.await();
                    }
                    Thread.sleep(new Random().nextInt(1000));
                    queue.add("AAA");
                    System.out.println("生产一个对象");
                    notEmpty.signal();
                } catch (InterruptedException e) {

                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        Producer p = new Producer();
        Consumer c = new Consumer();
        new Thread(p).start();
        new Thread(c).start();
    }
}
