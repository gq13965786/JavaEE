package com.qguo.decorator;

import com.qguo.base.Isomebase;

public class UppercaseDecorator extends SomebaseWrapper {
	// 大小写装饰者
	
	@Override
	public String dostring() {
		return super.dostring().toUpperCase();
	}

	public UppercaseDecorator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UppercaseDecorator(Isomebase target) {
		super(target);
		// TODO Auto-generated constructor stub
	}

}
