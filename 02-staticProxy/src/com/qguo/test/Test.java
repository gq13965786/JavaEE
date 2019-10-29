package com.qguo.test;

import com.qguo.proxy.SomeProxy;
import com.qguo.some.ISome;
//import com.qguo.some.SomeImpl;

public class Test {

	public static void main(String[] args) {
		ISome some = new SomeProxy();
		
		String s = some.dostring();
		
		System.out.println(s);
	}

}
