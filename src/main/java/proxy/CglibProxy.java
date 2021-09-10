package proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author sunmengyuan
 * @date 2021-09-10
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
