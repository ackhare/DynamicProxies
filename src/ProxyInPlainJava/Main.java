package ProxyInPlainJava;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chetan on 19/11/16.
 */
public class Main {
    public static void main(String[] args) {
List list=new ArrayList();
        list.add(2);
        list.add(3);
/*
The newProxyInstance method takes 3 arguments:
the class loader
an array of interfaces that will be implemented by the proxy
the power behind the throne in the form of the invocation handler
Now, if you try to add elements to the proxy by calling any add methods, it won’t have any effect.

 */
        List proxy = (List) Proxy.newProxyInstance(
                Main.class.getClassLoader(),
                new Class[] { List.class },
                new NoOpAddInvocationHandler(list));
        proxy.add(4);
        proxy.add(6);
        proxy.add(5);
        System.out.println(proxy.size());
    }
}
