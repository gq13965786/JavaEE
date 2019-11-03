package com.qguo.cglibimpl;

import java.lang.reflect.Method;

import com.qguo.dynamic.Some;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyCglibFactory implements MethodInterceptor{
	private Some target;

	public MyCglibFactory() {
		target = new Some();
	}

	public Some myCglibCreator() {
		//创建增强器对象
		Enhancer enhancer = new Enhancer();
		//指定目标类,给予目标为父类
		enhancer.setSuperclass(Some.class);
		//设置本对象的回调点
		enhancer.setCallback(this);
		
		return (Some) enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
			throws Throwable {
		Object result = Some.class.getDeclaredMethod("otherthan", null).invoke(target , args);
		
		if (result != null) {
		result = ((String)result).toUpperCase();
		}
		
		return result;
	}


}
