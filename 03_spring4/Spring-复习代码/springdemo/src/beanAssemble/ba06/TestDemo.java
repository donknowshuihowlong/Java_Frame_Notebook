package beanAssemble.ba06;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {

	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beanAssemble/application-ba06.xml");
		// 从容器获取Service
		IUserService userService = (IUserService) ac.getBean("userService");
		userService.doSome();
		userService.doOther();
		// 关闭容器对象
		((ClassPathXmlApplicationContext) ac).close();
	}
}
