package com.qguo.decorator;

import com.qguo.base.Isomebase;

public class SomebaseWrapper implements Isomebase {
	
	private Isomebase target;
	
	
	public SomebaseWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SomebaseWrapper(Isomebase target) {
		super();
		this.target = target;
	}


	//װ���߶���
	@Override
	public String dostring() {
		
		return target.dostring();
	}

}
