package spi;

import java.util.ServiceLoader;

/**
 * @author sunmengyuan
 * @date 2021-09-10
 */
public class SpiTest {
    public static void main(String[] args) {
        ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);
        for (IShout s : shouts) {
            s.shout();
        }
    }
}
