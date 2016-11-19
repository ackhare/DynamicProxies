package ProxyWithJavaAssist;

/**
 * Created by chetan on 19/11/16.
 */
import java.lang.reflect.Method;
import java.util.ArrayList;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

public class ProxyCreator {
    public static void main(String[] args){
        try {
            ArrayList list = create(ArrayList.class);
            list.add("foo");
            System.out.println(list.getClass().getName());
            System.out.println("===========================");
//			Foo foo = create(Foo.class);
            Bar bar = create(Bar.class);
            bar.bar();
            bar.bar1();
            bar.bar2();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static <T> T create(Class<T> classs) throws Exception {
        System.out.println(classs);
        ProxyFactory factory = new ProxyFactory();
        factory.setSuperclass(classs);
        Class clazz = factory.createClass();
        MethodHandler handler = new MethodHandler() {

            @Override
            public Object invoke(Object self, Method overridden, Method forwarder,
                                 Object[] args) throws Throwable {
                System.out.println("do something "+overridden.getName());
                return forwarder.invoke(self, args);
            }
        };
        Object instance = clazz.newInstance();
        ((ProxyObject) instance).setHandler(handler);
        return (T) instance;
    }
}

final class Foo{}
class Bar{
    public static void bar(){
        System.out.println("bar");
    }
    public final void bar1(){
        System.out.println("bar1");
    }

    public void bar2(){
        System.out.println("bar2");
    }
}
