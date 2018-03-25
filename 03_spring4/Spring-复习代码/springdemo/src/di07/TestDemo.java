package di07;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("di07/application.xml");
		Student student1 = (Student) ac.getBean("student1");
		System.out.println(student1);
		Student student2 = (Student) ac.getBean("student2");
		System.out.println(student2);
	}
}
