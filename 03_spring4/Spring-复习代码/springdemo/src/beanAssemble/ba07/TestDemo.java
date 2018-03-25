package beanAssemble.ba07;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {

	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beanAssemble/application-ba07.xml");
		// 从容器获取Service
		IService studentService = (IService) ac.getBean("studentService");
		studentService.doSome();
		((ClassPathXmlApplicationContext) ac).close();
	}
}
