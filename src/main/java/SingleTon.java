/**
 * @author sunmengyuan
 * @date 2021-09-23
 */
public class SingleTon {
    private static SingleTon singleTon = new SingleTon();
    public static int count1;
    public static int count2 = 0;

    private SingleTon() {
        count1++;
        count2++;
    }

    public static SingleTon getInstance() {
        return singleTon;
    }

    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.getInstance();
        System.out.println("count1=" + SingleTon.count1);
        System.out.println("count2=" + SingleTon.count2);
    }

}

/**
 * 实例二
 * package com.example.classes;
 * <p>
 * public class SingleTon {
 * public static int count1;
 * public static int count2 = 0;
 * private static SingleTon singleTon = new SingleTon();
 * <p>
 * <p>
 * private SingleTon() {
 * count1++;
 * count2++;
 * }
 * <p>
 * public static SingleTon getInstance() {
 * return singleTon;
 * }
 * <p>
 * public static void main(String[] args) {
 * SingleTon singleTon = SingleTon.getInstance();
 * System.out.println("count1=" + singleTon.count1);
 * System.out.println("count2=" + singleTon.count2);
 * }
 * <p>
 * }
 * <p>
 * 出现这种情况的原因是java代码是顺序执行的，在实例一中是先实例化了一个singleTon实例，那这个时候两个值都是默认值也就是0，
 * 然后在进行++操作之后都变成了1，但是顺序执行的过程中，count2又被重新赋值了，这个时候就把原有值覆盖掉了。
 * 但是实例二的执行顺序是先进行赋值操作，然后在实例化singleTon对象，那这个时候已经完成了赋值操作了，后续的++是在赋值以后的基础上做的，
 */

