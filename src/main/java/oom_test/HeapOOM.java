package oom_test;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
    static class OOMObject {
//        int[] x = new int[2 * 1024];
    }

    public static void main(String[] args) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
            System.out.println(list.size());
            if (list.size() > 1111111) {
                Thread.sleep(11111111);
            }
        }
    }
}
