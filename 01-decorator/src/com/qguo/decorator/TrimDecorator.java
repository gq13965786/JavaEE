package com.qguo.decorator;

import com.qguo.base.Isomebase;

public class TrimDecorator extends SomebaseWrapper{
	
	public TrimDecorator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrimDecorator(Isomebase target) {
		super(target);
		// TODO Auto-generated constructor stub
	}

	// ÷ÿ–¥dostring()∑Ω
	@Override
	public String dostring() {
		return super.dostring().trim();
		
	}
}
