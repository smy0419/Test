import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunmengyuan
 * @date 2021-09-29
 * 使用锁交替打印奇偶
 */
public class PrintOddAndEvenWithLock {
    private static Integer i = new Integer(0);
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(new OddPrinter());
        Thread t2 = new Thread(new EvenPrinter());
        t1.start();
        t2.start();
    }

    static class OddPrinter implements Runnable {
        @Override
        public void run() {
            while (i <= 100) {
                if (i % 2 != 0) {
                    lock.lock();
                    try {
                        System.out.println("OddPrinter Thread print " + i);
                        i++;
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
    }

    static class EvenPrinter implements Runnable {
        @Override
        public void run() {
            while (i <= 100) {
                if (i % 2 == 0) {
                    lock.lock();
                    try {
                        System.out.println("EvenPrinter Thread print " + i);
                        i++;
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
    }
}
