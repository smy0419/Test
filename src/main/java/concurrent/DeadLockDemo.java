package concurrent;

/**
 * @author smy
 * @date 2021-09-20
 * 这个demo演示一个典型死锁的例子
 * 两个线程都持有对方需求的一个对象，并请求另外一个对象
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread t1 = new Thread(new T1(o1, o2));
        Thread t2 = new Thread(new T2(o1, o2));
        t1.start();
        t2.start();
    }

    static class T1 implements Runnable {
        private final Object o1;
        private final Object o2;

        public T1(Object o1, Object o2) {
            this.o1 = o1;
            this.o2 = o2;
        }

        @Override
        public void run() {
            synchronized (o1) {
                System.out.println("i get o1");
                try {
                    Thread.sleep(100);
                    synchronized (o2) {
                        System.out.println("do something...");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class T2 implements Runnable {
        private final Object o1;
        private final Object o2;

        public T2(Object o1, Object o2) {
            this.o1 = o1;
            this.o2 = o2;
        }

        @Override
        public void run() {
            synchronized (o2) {
                System.out.println("i get o2");
                try {
                    Thread.sleep(100);
                    synchronized (o1) {
                        System.out.println("do something...");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
