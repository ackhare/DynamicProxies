package ProxyWithJavaAssist.tuhrig;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

import java.awt.event.ActionListener;
import java.lang.reflect.Method;

/**
 * Created by chetan on 19/11/16.
 */
public class Test {

	public static void main(String[] args) throws Exception {

	    ProxyFactory factory = new ProxyFactory();

            factory.setInterfaces(new Class[] { ActionListener.class });

            factory.setHandler(new MethodHandler() {

		public Object invoke(Object arg0, Method method, Method arg2, Object[] arg3) throws Throwable {

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

	    Class c = factory.createClass();

	    Object object = c.newInstance();

	    ((ActionListener) object).actionPerformed(null);
	}
}
