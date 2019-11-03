package com.qguo.dynamic;

public class SomeImpl implements ISome {
	
	public String dostring() {
		System.out.println("dostring is impl");
		return "abcd";
	}
	
	public void otherthan() {
		System.out.println("method is not from interface");
	}
}
