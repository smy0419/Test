/**
 * @author sunmengyuan
 * @date 2021-09-29
 */
public class PrintOddAndEvenWithWaitNotify {
    private static Integer i = new Integer(0);
    private static Object lock = new Object();

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
                synchronized (lock) {
                    if (i % 2 != 0) {
                        System.out.println("OddPrinter Thread print " + i);
                        i++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    static class EvenPrinter implements Runnable {
        @Override
        public void run() {
            while (i <= 100) {
                synchronized (lock) {
                    if (i % 2 == 0) {
                        System.out.println("EvenPrinter Thread print " + i);
                        i++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
