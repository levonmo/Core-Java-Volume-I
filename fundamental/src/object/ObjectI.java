package object;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

//´úÀí
public class ObjectI  {
	
	public static void main(String[] args) {
		Object[] array = new Object[1000];
		for (int i = 0; i < array.length; i++) {
			Integer value = i + 1;
			TraceHandler handler = new TraceHandler(value);
			Object proxy = Proxy.newProxyInstance(null, new Class[] {Comparable.class}, handler);
			array[i] = proxy;
		}
		
		Integer key = new Random().nextInt(array.length) + 1;
		
		int result = Arrays.binarySearch(array, key);
		
		if (result >= 0) {
			System.out.println(array[result]);
		}
	}
	
}

class TraceHandler implements InvocationHandler {

	private Object target;
	
	public TraceHandler(Object t) {
		target = t;
	}
	
	public Object invoke(Object proxy, Method m, Object[] args)
			throws Throwable {
		System.out.println(target);
		System.out.println("." + m.getName() + "(");
		
		if(args != null){
			for (int i = 0; i < args.length; i++) {
				System.out.println(args[i]);
				if(i < args.length){
					System.out.println(",");
				}
			}
		}
		System.out.println(")");
		return m.invoke(target, args);
	}
	
}
