package guanlian;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import guanlian.dao.ICountry;
import guanlian.dao.INewsLabelDao;
import guanlian.dao.IPerson;
import guanlian.pojo.Country;
import guanlian.pojo.NewsLabel;
import guanlian.pojo.Person;
import guanlian.util.MyBatisUtil;


public class TestDemo1 {
	private ICountry Cdao;
	private IPerson Pdao;
	private INewsLabelDao Ndao;
	private SqlSession session;
	String path = "guanlian/SqlMapConfig.xml";
	boolean autoCommitOrNot = true;
	
	@Before
	public void setUp() {
		//这里把数据库修改设置为自动提交，方便测试
		session = MyBatisUtil.getSqlSession(path,autoCommitOrNot);
		//Mapper动态代理，需要使用session的getMapper方法获取接口实现类的动态代理对象
		Cdao = session.getMapper(ICountry.class);
		Pdao = session.getMapper(IPerson.class);
		Ndao = session.getMapper(INewsLabelDao.class);
	}
	@After
	public void tearDown() {
		//关闭SqlSession
		if(session != null) {
			session.close();
		}
	}
	//多表关联查询
	//一对多查询 查询一的一方的信息， 同时获取多的一方的信息
	@Test
	public void testselectCountryById() {
		Country selectCountryById = Cdao.selectCountryById(1);
		System.out.println(selectCountryById);
	}
	//配合做一对多查询的第二个方式的测试
	@Test
	public void testselectPersonByCountryId() {
		List<Person> list = new ArrayList<Person>();
		list = Pdao.selectPersonByCountryId(1);
		for (Person person : list) {
			System.out.println(person);
		}
	}
	//多对一查询 查询多的一方的信息，同时获取一的一方的信息
	@Test
	public void testselectPersonById() {
		Person per = Pdao.selectPersonById(3);
		System.out.println(per);
	}
	//自关联测试
	//
	/*
	 * <!-- 1. 查询出指定栏目的所有子孙栏目 -->
	 * <!-- 形成递归查询，每次查询结果继续调用 -->
	 */
	@Test
	public void testselectChildrenByParentId() {
		List<NewsLabel> lilst = Ndao.selectChildrenByParentId(2);
		for (NewsLabel newsLabel : lilst) {
			System.out.println(newsLabel);
		}
	}
	//2. 查询出指定栏目以及所有子孙栏目
	@Test
	public void testselectNewsLabelById() {
		NewsLabel newsLabel = Ndao.selectNewsLabelById(1);
		System.out.println(newsLabel);
	}
	//多对一的处理方式
	@Test
	public void testselectParentByParentId() {
		NewsLabel par = Ndao.selectParentByParentId(3);
		System.out.println(par);
	}
}
