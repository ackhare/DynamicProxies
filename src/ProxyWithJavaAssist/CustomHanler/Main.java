//package ProxyWithJavaAssist.CustomHanler;
//
//import javassist.util.proxy.Proxy;
//import javassist.util.proxy.ProxyFactory;
//
///**
// * Created by chetan on 19/11/16.
// */
//public class Main {
//    public static void main(String[] args) {
//        MyEntity myEntity = new MyEntity();
//        ProxyFactory factory = new ProxyFactory();
//        factory.setSuperclass(myEntity.getClass());
//        factory.setInterfaces(new Class[] { MyCustomInterface.class });
//        Class cls = factory.createClass();
//
//// bind your newly methodHandler to your proxy
//        ((Proxy)).setHandler(new CustomMethodHandler(myEntity));
//        MyEntity proxyEntity = cls.newInstance();
//    }
//}
