package com.qguo.test;

import org.omg.SendingContext.RunTime;

public class Test {
	public native static void hellnative();
	
	//static {
	//	system.loadlibrary("*.dll");
	//}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String home = System.getenv("JAVA_HOME")+"/jre/bin/server/jvm.dll";replace / to \
		//on the way to get 
		
		//JNIEXPORT jint JNICALL 
		//Agent_OnLoad(JavaVM *vm, char *options, void *reserved)
		
		//System.out.println(home);
		//System.loadLibrary(home);

		int number = Runtime.getRuntime().availableProcessors();
		System.out.println(number);
	}
	

}
