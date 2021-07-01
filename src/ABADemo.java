import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * @author sunmengyuan
 * @date 2021-05-17
 */
public class ABADemo {
    static AtomicMarkableReference<Integer> atMarkRef = new AtomicMarkableReference<Integer>(10, false);

    static Thread t5 = new Thread(new Runnable() {
        @Override
        public void run() {
            boolean mark = atMarkRef.isMarked();
            System.out.println("mark:" + mark);
            //更新为20
            System.out.println("t5 result:" + atMarkRef.compareAndSet(atMarkRef.getReference(), 20, mark, !mark));
        }
    });

    static Thread t6 = new Thread(new Runnable() {
        @Override
        public void run() {
            boolean mark2 = atMarkRef.isMarked();
            System.out.println("mark2:" + mark2);
            System.out.println("t6 result:" + atMarkRef.compareAndSet(atMarkRef.getReference(), 10, mark2, mark2));
        }
    });

    static Thread t7 = new Thread(new Runnable() {
        @Override
        public void run() {
            boolean mark = atMarkRef.isMarked();
            System.out.println("sleep 前 t7 mark:" + mark);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mark = atMarkRef.isMarked();
            System.out.println("sleep 后 t7 mark:" + mark);
            boolean flag = atMarkRef.compareAndSet(10, 50, mark, !mark);
            System.out.println("flag:" + flag + ",newValue:" + atMarkRef.getReference());
        }
    });

    public static void main(String[] args) throws InterruptedException {

        t5.start();
        t5.join();
        t6.start();
        t6.join();
        t7.start();

        /**
         * 输出结果:
         mark:false
         t5 result:true
         mark2:true
         t6 result:true
         sleep 前 t5 mark:false
         flag:true,newValue:50 ---->成功了.....说明还是发生ABA问题
         */
    }
}
