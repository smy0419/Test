package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Java动态代理demo
 *
 * @author sunmengyuan
 * @date 2021-09-10
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke, do something...");
        Object result = method.invoke(target, args);
        System.out.println("after invoke, do something...");
        return result;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        Person p = new Women();
        MyInvocationHandler handler = new MyInvocationHandler(p);
        Person proxy = (Person) handler.getProxy();
        proxy.sayHi("lucy");
    }

}
