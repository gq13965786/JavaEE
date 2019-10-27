package com.qguo.decorator;

import com.qguo.base.Isomebase;

public class SomebaseDecorator implements Isomebase {
	
	private Isomebase target;
	
	
	public SomebaseDecorator(Isomebase target) {
		super();
		this.target = target;
	}


	//װ���߶���
	@Override
	public String dostring() {
		
		return target.dostring().toUpperCase();
	}

}
