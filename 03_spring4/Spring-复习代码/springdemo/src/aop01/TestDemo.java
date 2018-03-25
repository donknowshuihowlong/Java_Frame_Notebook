package aop01;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:aop01/application.xml")
public class TestDemo {
//	@Resource(name="userService")
	private IUserService us;
	
	@Test
	public void fun1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("aop01/application.xml");
		us = (IUserService) ac.getBean("userService");
		us.save();
	}
}
