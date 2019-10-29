package com.qguo.test;

import com.qguo.data.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test {

	public static void main(String[] args) {

		Class reflectClass = Student.class;
		
		String className = reflectClass.getName();
		
		System.out.println("set reflection to: " + className + "\n");
		
		int classModifier = reflectClass.getModifiers();
		// isAbstract, isFinal, isInterface, isPrivate, isProtector
		// isStatic, isStrict, isSynchronized, isVolatile
		System.out.println("isPublic: " + Modifier.isPublic(classModifier) + "\n");
		
		Class[] interfaces = reflectClass.getInterfaces();
		
		System.out.println("size of interfaces: " + interfaces.length);
		for(int i = 0; i < interfaces.length; i++) {
			System.out.println("--------------");
			System.out.print("interface: " + interfaces[i]);
		}
		
		Class classSuper = reflectClass.getSuperclass();
		
		System.out.println("super class: " + classSuper.getName() + "\n");
		
		Method[] classMethods = reflectClass.getMethods();
		
		for(Method method : classMethods) {
			System.out.println("Method Name: " + method.getName());
			
			if(method.getName().startsWith("get")) {
				System.out.print(":Getter Method");
			} else if(method.getName().startsWith("set")) {
				System.out.print(":Setter Method");
			}
			
			System.out.println("->return Type: " + method.getReturnType());
			
			Class[] parameterType = method.getParameterTypes();
			
			System.out.print("Parameters: ");
			
			for(Class parameter : parameterType) {
				System.out.println(parameter.getTypeName() + "\b");
			}
			
			System.out.println("\n");
			
		}
		System.out.println("------------constructor---------------");
		//before invoke constructor, get parameterType
		Constructor constructor1 = null;
		Object constructor = null;
		
		try {
			constructor = reflectClass.getConstructor(String.class, Integer.class, int.class).newInstance("David",10,90);
			constructor1 = reflectClass.getConstructor(new Class[] {Student.class});
			
			Class[] constructorParameters = constructor1.getParameterTypes();
			
			for(Class parameter : constructorParameters) {
				System.out.println(parameter.getName());
			}
			
			constructor1.newInstance(new Student("York",20, 90));
			System.out.print("-------end------" +"\n\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("-----access private field&method---------");
		Field privateStringName;
		Method privateMethod;
		Method otherMethod;
		try {
			privateStringName = Student.class.getDeclaredField("name");
			privateStringName.setAccessible(true);		
			System.out.println((String)privateStringName.get(new Student("Dave", 30, 93)));
			
			String mname = "privatemethod";
			privateMethod = Student.class.getDeclaredMethod(mname, null);
			privateMethod.setAccessible(true);
			
			privateMethod.invoke(Student.class.newInstance(), null);
			// excute private method with parameter
			String other = "paraPrivate";
			Class[] methodParameters = new Class[] {Integer.TYPE,String.class};
			Object[] params = new Object[] { new Integer(20), new String("random")};
			otherMethod = Student.class.getDeclaredMethod(other, methodParameters);
			otherMethod.setAccessible(true);
			otherMethod.invoke(Student.class,params);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-----access private field&method----------");
		
		
	}//end main

}//end class










