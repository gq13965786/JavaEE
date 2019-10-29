package com.qguo.proxy;

import com.qguo.some.ISome;
import com.qguo.some.SomeImpl;

public class SomeProxy implements ISome{
	private ISome target;

	public SomeProxy() {
		target = new SomeImpl();
	}

	@Override
	public String dostring() {

		return target.dostring().toUpperCase();
	}
	
	
}
