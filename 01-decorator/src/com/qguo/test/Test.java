package com.qguo.test;

import com.qguo.base.Isomebase;
import com.qguo.base.SomebaseImpl;
//import com.qguo.decorator.SomebaseWrapper;
import com.qguo.decorator.TrimDecorator;
import com.qguo.decorator.UppercaseDecorator;

public class Test {

	public static void main(String[] args) {
		//����Ŀ�����
		Isomebase target = new SomebaseImpl();
		//ʹ��Ŀ��������Ĳ���������װ����
		Isomebase some = new TrimDecorator(target);
		Isomebase some2 = new UppercaseDecorator(some);
		//�ѵ�һ��װ���ߵĽ�����ڶ���װ���ߵĲ������γɡ�װ����������
		//����ֵһ�£����Կ��С�
		//��������������� smalltalk
		String result = some2.dostring();
		System.out.println("result = " + result);

	}

}