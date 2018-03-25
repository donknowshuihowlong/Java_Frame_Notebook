package dao_jdbcTemplate;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
	private IUserService service;
	@Before
	public void setUp() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("dao_jdbcTemplate/applicationContext.xml");
		service = (IUserService) ac.getBean("service");
	}
	@Test
	public void testInsert() {
		User user = new User("xiaoxiao",24);
		service.add(user);
	}
	@Test
	public void testDelete() {
		service.remove(4);
	}
	@Test
	public void testUpdate() {
		User user = new User("xiaoming",24);
		service.add(user);
		user.setId(5);
		user.setAge(100);
		service.modify(user);
	}
	@Test
	public void testFindUsernameById() {
		System.out.println(service.findUsernameById(1));
	}
	@Test
	public void testFindUsernameByAge() {
		List<String> list = service.findUsernameByAge(24);
		for (String str : list) {
			System.out.println(str);
		}
	}
	@Test
	public void testFindUserById() {
		User iduser = service.findUserById(1);
		System.out.println(iduser);
	}
	@Test
	public void testFindAllUser() {
		List<User> findAllUser = service.findAllUser();
		for(User user : findAllUser) {
			System.out.println(user);
		}
	}
}
