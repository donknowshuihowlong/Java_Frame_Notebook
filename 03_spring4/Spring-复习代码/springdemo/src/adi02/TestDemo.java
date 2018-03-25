package adi02;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//帮我们创建容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定创建容器时使用哪个配置文件
@ContextConfiguration("classpath:adi02/application.xml")
public class TestDemo {
	//注入student给s
	@Resource(name="student")
	//@Autowired
	//@Qualifier("student")
	private Student s;
	
	@Test
	public void fun1() {
		//ApplicationContext ac = new ClassPathXmlApplicationContext("adi02/application.xml");
		//Student s = (Student) ac.getBean("student");
		System.out.println(s);
	}
}
