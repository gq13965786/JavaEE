package com.qguo.Test;

import com.qguo.dynamic.ISome;
import com.qguo.dynamic.SomeImpl;

public class test {

	public static void main(String[] args) {
		System.out.println("------begin-------");
		ISome some = new SomeImpl();
		some.dostring();
		
		System.out.println("------end-------");

	}

}
