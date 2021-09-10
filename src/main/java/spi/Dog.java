package spi;

/**
 * @author sunmengyuan
 * @date 2021-09-10
 */
public class Dog implements IShout {
    @Override
    public void shout() {
        System.out.println("wang wang");
    }
}
