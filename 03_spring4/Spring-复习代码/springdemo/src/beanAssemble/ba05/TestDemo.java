package beanAssemble.ba05;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {

	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beanAssemble/application-ba05.xml");
		// 从容器获取Service
		IService studentService = (IService) ac.getBean("studentService");
		studentService.doSome();
		studentService.doOther();
		
		IService teacherService = (IService) ac.getBean("teacherService");
		teacherService.doSome();
		teacherService.doOther();
	}
}
