package beanAssemble.ba07;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
	/**
	 * @param arg0 系统即将初始化的Bean实例
	 * @param arg1 Bean实例的ID属性值(或者name)
	 */
	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		//即使不对Bean进行增强，也要返回Bean，不能为null
		System.out.println("BeanPostProcessor接口的postProcessAfterInitialization()方法");
		return arg0;
	}
	/**
	 * 对StudentServiceImpl进行增强
	 * @param arg0 系统即将初始化的Bean实例
	 * @param arg1 Bean实例的ID属性值(或者name)
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		//反射
		if (bean instanceof StudentServiceImpl) {
			//proxy就是动态代理生成的一个队指定接口的实现类对象，可以直接调用实现类的方法proxy.xxx()
			//newProxyInstance(classLoader,intefaces,InvocationHandler())
			//第1个参数，实现类的类加载器
			//第2个参数，实现类所实现的接口
			//第3个参数，InvocationHandler()接口，调用处理器
			/*
			 * 只有1个方法invoke()
			 * Object proxy：代理对象，也就是Proxy.newProxyInstance()方法返回的对象
			 * Method method：表示当前被调用方法的反射对象，例如proxy.some()，那么method就是some()方法的反射对象
			 * Object[] args：表示当前被调用方法的参数
			 * invoke()方法的返回值为Object类型，它表示当前被调用的方法的返回值，没有返回值的话，就是返回null
			*/
			/* ===================================================================================
			 * public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
							return result;
						}
			 * ===================================================================================
			 * 
			 * ===================================================================================
			 * Object result = proxy.method(args)
			 * ===================================================================================
			 * 
			 * 上面这两段代码的对应
			 * result -> result
			 * proxy -> proxy
			 * method -> method
			 * args -> args
			 * 
			 * ===================================================================================
			 * 无论调用代理对象上的哪个方法，其实都是在调用InvocationHandler的invoke()方法
			 * 所以invoke()返回的就是method.invoke(bean,args)
			 */
			Object proxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(), 
					bean.getClass().getInterfaces(), 
					new InvocationHandler() {

						@Override
						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
							if ("doSome".equals(method.getName())) {
								System.out.println("BeanPostProcessor接口的方法增强，下一步调用业务");
								//执行目标方法doSome()
								Object invoke = method.invoke(bean, args);
								return invoke;
							}
							return method.invoke(bean, args);
						}
			});
			return proxy;
		}
		return bean;
	}
}
