package com.qguo.test;

import com.qguo.base.Isomebase;
import com.qguo.base.SomebaseImpl;
import com.qguo.decorator.SomebaseDecorator;

public class Test {

	public static void main(String[] args) {
		//创建目标对象
		Isomebase target = new SomebaseImpl();
		//使用目标对象作文参数，创建装饰者
		Isomebase some = new SomebaseDecorator(target);
		String result = some.dostring();
		System.out.println("result = " + result);

	}

}