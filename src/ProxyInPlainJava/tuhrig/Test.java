package ProxyInPlainJava.tuhrig;

import java.awt.event.ActionListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by chetan on 19/11/16.
 */
public class Test {

     public static void main(String[] args) {

        ClassLoader cl = Test.class.getClassLoader();
        Class[] interfaces = new Class[]{ ActionListener.class };

        Object object = Proxy.newProxyInstance(cl, interfaces, new InvocationHandler() {

            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                String name = method.getName();

                if(name.equals("toString")) {

                    return "toString was called";
                }
                else if(name.equals("actionPerformed")) {

                    System.out.println("actionPerformed was called");

                    return null;
                }

                throw new RuntimeException("no method found");
            }
        });

	((ActionListener) object).actionPerformed(null);
    }
}
