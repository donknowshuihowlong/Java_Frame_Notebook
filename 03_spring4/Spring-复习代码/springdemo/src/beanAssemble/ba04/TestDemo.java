package beanAssemble.ba04;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
	/**
	 * getBean()首先调用的是无参构造 
	 * true 
	 * getBean()首先调用的是无参构造 
	 * getBean()首先调用的是无参构造 
	 * false
	 */
	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beanAssemble/application-ba04.xml");
		// 从容器获取Service
		IUserService bean1 = (IUserService) ac.getBean("userService1");
		IUserService bean2 = (IUserService) ac.getBean("userService1");
		System.out.println(bean1 == bean2);// true

		IUserService bean3 = (IUserService) ac.getBean("userService2");
		IUserService bean4 = (IUserService) ac.getBean("userService2");
		System.out.println(bean3 == bean4);// false
	}
}
