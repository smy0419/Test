package proxy;

/**
 * @author sunmengyuan
 * @date 2021-09-10
 */
public class Women implements Person, Human {
    @Override
    public void sayHi(String name) {
        System.out.println("hi,my name is " + name + ",i am a girl.");
    }

    @Override
    public void eat(String food) {
        System.out.println("I like eat " + food);
    }
}
