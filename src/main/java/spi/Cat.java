package spi;

/**
 * @author sunmengyuan
 * @date 2021-09-10
 */
public class Cat implements IShout {
    @Override
    public void shout() {
        System.out.println("miao miao");
    }
}
