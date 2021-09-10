package proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib动态代理
 * @author sunmengyuan
 * @date 2021-09-10
 * CGLib创建的动态代理对象性能比JDK创建的动态代理对象的性能高不少，但是CGLib在创建代理对象时所花费的时间却比JDK多得多，
 * 所以对于单例的对象，因为无需频繁创建对象，用CGLib合适，反之，使用JDK方式要更为合适一些。
 * 同时，由于CGLib由于是采用动态创建子类的方法，对于final方法，无法进行代理
 */
public class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    private Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before invoke...");
        // 关键代码
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("after invoke...");
        return o1;
    }

    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        Women womenProxy = (Women) proxy.getProxy(Women.class);
        womenProxy.sayHi("vivian");
    }
}
