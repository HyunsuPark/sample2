package com.sample.load;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLClassLoader;


public class ClassLoader {

	public void init(String src) {
		JarClassLoader classLoader = null;
		Class cls = null;
		Object obj = null;
		
		try {
			classLoader = new JarClassLoader(src);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String className = "com.sample.HelloSample";
		String methodName = "load";

		
		try {
			cls = classLoader.findClass(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			obj = cls.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
		}
		
		Method[] meth = cls.getDeclaredMethods();
		for (Method m : meth) {
			String mName = m.getName();
			 
			if (methodName.equals(mName)) {
//				System.out.println("find : " + m);

				// 객체실행
				try {
					m.invoke(obj, null);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("Class Loading Success");
	}
	
}
