/**
 * @author sunmengyuan
 * @date 2021-05-14
 */
public class FieldHashNoPolymorphic {
    static class Father {
        public int money = 1;
        public Father() {
            money = 2;
            showMeTheMoney();
        }
        public void showMeTheMoney() {
            System.out.println("I am Father, I have $" + money);
        }
    }
    static class Son extends Father {
        public int money = 3;
        public Son() {
            money = 4;
            showMeTheMoney();
        }
        @Override
        public void showMeTheMoney() {
            System.out.println("I am Son, I have $" + money);
        }
    }
    public static void main(String[] args) {
        Father guy = new Son();
        // 通过静态类型访问到了父类中的money，输出2
        System.out.println("This guy has $" + guy.money);
        // 将静态类型强转成Son，访问的就是子类中的money，输出4
        System.out.println("This guy has $" + ((Son) guy).money);
    }
}
