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
            // 子类构造方法会默认先执行父类构造方法
            super();
            money = 4;
            showMeTheMoney();
        }

        @Override
        public void showMeTheMoney() {
            System.out.println("I am Son, I have $" + money);
        }
    }
    public static void main(String[] args) {
        /**
         * I am Son, I have $0
         * I am Son, I have $4
         * This guy has $2
         * This guy has $4
         */
        // 分析：new Son()会调用子类构造方法，因为Son继承了Father，所以首先会执行父类的构造方法
        // 此时父类的money = 2,然后执行showMeTheMoney方法，因为子类覆盖了此方法，所以会执行子类中的此方法；
        // 因为子类的money赋初值操作还未执行，所以money此时等于int的初始值0，所以子类的showMeTheMoney打印 I am Son, I have $0
        // 然后执行子类的构造方法，将money赋值为4，所以后续打印I am Son, I have $4
        // Father guy = new Son();执行完成后，guy的符号引用指向子类对象Son
        Father guy = new Son();
        // 通过静态类型访问到了父类中的money，输出2
        System.out.println("This guy has $" + guy.money);
        // 将静态类型强转成Son，访问的就是子类中的money，输出4
        System.out.println("This guy has $" + ((Son) guy).money);
    }
}
