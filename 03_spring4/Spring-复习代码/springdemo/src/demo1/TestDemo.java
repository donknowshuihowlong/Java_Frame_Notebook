package demo1;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class TestDemo {
	/**
	 * 使用ApplicationContext容器获取对象
	 */
	@Test
	public void test01() {
		//获取容器，此时容器中的所有对象都装配完毕
		ApplicationContext ac = new ClassPathXmlApplicationContext("application-demo1.xml");
		//从容器获取对象，直接从内存中取出
		IStudentService bean = (IStudentService) ac.getBean("studentService");
		bean.some();
	}
	/**
	 * 使用BeanFactory容器获取对象
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void test02() {
		//获取容器，此时容器中的所有对象没有装配
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("application-demo1.xml"));
		IStudentService bean = (IStudentService) bf.getBean("studentService");
		bean.some();
	}
}
