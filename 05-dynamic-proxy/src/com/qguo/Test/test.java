package com.qguo.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.qguo.dynamic.ISome;
import com.qguo.dynamic.SomeImpl;

public class Test {

	public static void main(String[] args) {
		// 接口声明
		System.out.println("------begin-------");
		ISome some = new SomeImpl();
		some.dostring();
//		some.otherthan(); 没有在接口声明
		System.out.println("------end-------");
		System.out.println("----jdk dynamic proxy----");
		//jdk 实现动态代理
		//要求目标对象增强要有接口
		final ISome target = new SomeImpl();//final
		System.out.println(target.dostring());
		ISome other = (ISome) Proxy.newProxyInstance(
//							ISome.class.getClassLoader(),
							target.getClass().getClassLoader(),
//							ISome.class.getInterfaces(),
							target.getClass().getInterfaces(),
							new InvocationHandler() {			
								//proxy:代理对象
								//method:目标方法
								//args:目标方法的参数列表
								@Override
								public Object invoke(Object proxy, Method method, Object[] args)
										throws Throwable {
									// target调用函数的时候可以有只采取返归实例的方法,以此来实现完全的面向对象编程
									//如果没有返回值 要小心 nullpointException
									//
									//method.getName();用来指定特定的函数
									Object result = method.invoke(target, args);
									result = ((String)result).toUpperCase();
									return result;
								}});
		
		String s = other.dostring();
		System.out.println(s);
		System.out.println("----cglib dynamic proxy----");
		//cglib 实现动态代理
		//要求目标对象增强用的是继承关系,增强对象不能是final类
	}

}
