package ProxyWithCglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by chetan on 19/11/16.
 */
public class HashCodeAlwaysZeroMethodInterceptor implements MethodInterceptor {
    public Object intercept(Object object, Method method, Object[] args,
                            MethodProxy methodProxy) throws Throwable {
        if ("hashCode".equals(method.getName())) {
            return 0;
        }
        return methodProxy.invokeSuper(object, args);
    }

}
