package beanAssemble.ba02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beanAssemble/application-ba02.xml");
		//从容器获取Service
		IUserService bean = (IUserService) ac.getBean("userService");
		bean.doSome();
		bean.doOther();
	}
}
