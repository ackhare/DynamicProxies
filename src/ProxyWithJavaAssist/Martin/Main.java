package ProxyWithJavaAssist.Martin;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

import java.lang.reflect.Method;

/**
 * Created by chetan on 19/11/16.
 */
public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        final IExample example = abcd();

        example.setName("name");

    }

    public static IExample abcd() throws IllegalAccessException, InstantiationException {
        ProxyFactory factory = new ProxyFactory();
        factory.setSuperclass(Example.class);
        Class aClass = factory.createClass();
        final IExample newInstance = (IExample) aClass.newInstance();
        MethodHandler methodHandler = new MethodHandler() {
            @Override
            public Object invoke(Object self, Method overridden, Method proceed, Object[] args) throws Throwable {
                //public void ProxyWithJavaAssist.Martin.Example.setName(java.lang.String)
                System.out.println(overridden.getName());
                return proceed.invoke(newInstance, args);
            }
        };
        ((ProxyObject) newInstance).setHandler(methodHandler);
        return newInstance;
    }
}
