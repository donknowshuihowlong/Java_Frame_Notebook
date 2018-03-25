package di08;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("di08/application.xml");
		Student student = (Student) ac.getBean("student");
		System.out.println(student);
		Teacher teacher = (Teacher) ac.getBean("teacher");
		System.out.println(teacher);
	}
}
