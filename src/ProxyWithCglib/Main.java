package ProxyWithCglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by chetan on 19/11/16.
 */
public class Main {
    public static void main(String[] args) {
        Object proxy = Enhancer.create(
                Object.class,
                new HashCodeAlwaysZeroMethodInterceptor());

    }
}
