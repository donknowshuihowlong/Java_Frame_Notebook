package di01_1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("di01_1/application.xml");
		Student student = (Student) ac.getBean("student");
		System.out.println(student);
	}
}
