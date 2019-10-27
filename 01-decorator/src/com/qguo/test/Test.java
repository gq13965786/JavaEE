package com.qguo.test;

import com.qguo.base.Isomebase;
import com.qguo.base.SomebaseImpl;
//import com.qguo.decorator.SomebaseWrapper;
import com.qguo.decorator.TrimDecorator;
import com.qguo.decorator.UppercaseDecorator;

public class Test {

	public static void main(String[] args) {
		//创建目标对象
		Isomebase target = new SomebaseImpl();
		//使用目标对象作文参数，创建装饰者
		Isomebase some = new TrimDecorator(target);
		Isomebase some2 = new UppercaseDecorator(some);
		//把第一个装饰者的结果做第二个装饰者的参数，形成“装饰者链条”
		//返回值一致，所以可行。
		//其他面向对象语言 smalltalk
		String result = some2.dostring();
		System.out.println("result = " + result);

	}

}