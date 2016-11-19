package ProxyInPlainJava;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by chetan on 19/11/16.
 */
public class NoOpAddInvocationHandler implements InvocationHandler {

    private final List proxied;

    public NoOpAddInvocationHandler(List proxied) {
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("add")) {
            System.out.println("lllllllllllll");
            return false;
        }
        return method.invoke(proxied, args);
    }
}

