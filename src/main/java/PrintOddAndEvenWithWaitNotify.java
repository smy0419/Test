/**
 * @author sunmengyuan
 * @date 2021-09-29
 * 使用wait-notify机制交替打印奇偶
 */
public class PrintOddAndEvenWithWaitNotify {
    private static int i;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new OddPrinter());
        Thread t2 = new Thread(new EvenPrinter());
        t1.start();
        t2.start();
    }

    static class OddPrinter implements Runnable {
        @Override
        public void run() {
            while (i < 100) {
                synchronized (lock) {
                    while (i % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("OddPrinter Thread print " + i++);
                    lock.notify();
                }
            }
        }
    }

    static class EvenPrinter implements Runnable {
        @Override
        public void run() {
            while (i < 100) {
                synchronized (lock) {
                    while (i % 2 == 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("EvenPrinter Thread print " + i++);
                    lock.notify();
                }
            }
        }
    }
}
