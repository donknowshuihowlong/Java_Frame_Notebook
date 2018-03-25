package di01_2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("di01_2/application.xml");
		Student student = (Student) ac.getBean("student2");
		System.out.println(student);
	}
}
