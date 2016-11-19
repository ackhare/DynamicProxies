package ProxyWithJavaAssist.Martin;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

import java.lang.reflect.Method;

/**
 * Created by chetan on 19/11/16.
 */
public class Main {
    public static void main(String[] args)  {
//final IExample example = JavaProxy.createExample();
//    long measure = TimeMeasurement.measure(new TimeMeasurement.Execution() {
//        @Override
//        public void execute() {
//            for (long i = 0; i < JavassistProxyTest.NUMBER_OF_ITERATIONS; i++) {
//                example.setName("name");
//            }
//        }
//    });
//    System.out.println("Proxy: "+measure+" ms");
    }

    public IExample abcd() throws IllegalAccessException, InstantiationException {
        ProxyFactory factory = new ProxyFactory();
        factory.setSuperclass(Example.class);
        Class aClass = factory.createClass();
        final IExample newInstance = (IExample) aClass.newInstance();
        MethodHandler methodHandler = new MethodHandler() {
            @Override
            public Object invoke(Object self, Method overridden, Method proceed, Object[] args) throws Throwable {
                return proceed.invoke(newInstance, args);
            }
        };
        ((ProxyObject)newInstance).setHandler(methodHandler);
        return newInstance;
    }
}
