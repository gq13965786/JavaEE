package com.qguo.test;

import org.omg.SendingContext.RunTime;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String home = System.getenv("JAVA_HOME")+"/jre/bin/server/jvm.dll";
		System.out.println(home);
//		System.loadLibrary(home);

		int number = Runtime.getRuntime().availableProcessors();
		System.out.println(number);
	}
	
	public native static void hellnative();
}
