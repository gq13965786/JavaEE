package com.qguo.test;

import com.qguo.base.Isomebase;
import com.qguo.base.SomebaseImpl;
import com.qguo.decorator.SomebaseDecorator;

public class Test {

	public static void main(String[] args) {
		//����Ŀ�����
		Isomebase target = new SomebaseImpl();
		//ʹ��Ŀ��������Ĳ���������װ����
		Isomebase some = new SomebaseDecorator(target);
		String result = some.dostring();
		System.out.println("result = " + result);

	}

}