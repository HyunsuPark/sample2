import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.sample.load.JarClassLoader;

public class Test {
	public static void main(String[] args) throws IOException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		JarClassLoader classLoader = new JarClassLoader("lib/hello.jar");

		String className = "com.sample.HelloSample";
		String methodName = "load";

		Class cls = classLoader.findClass(className);
		Object obj = cls.newInstance();
		
		Method[] meth = cls.getDeclaredMethods();
		for (Method m : meth) {
			String mName = m.getName();
			 
			if (methodName.equals(mName)) {
//				System.out.println("find : " + m);

				// 객체실행
				m.invoke(obj, null);
			}
		}
	}
}
