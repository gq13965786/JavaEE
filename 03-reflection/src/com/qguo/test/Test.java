package com.qguo.test;

import com.qguo.data.Student;

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
			System.out.println("Method Name: " + method.getName() + "\n");
			
		}
		
	}

}
