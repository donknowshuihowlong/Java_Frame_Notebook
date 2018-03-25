package di03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("di03/application.xml");
		MyCollections myCollections = (MyCollections) ac.getBean("myCollections");
		System.out.println(myCollections);
	}
}
