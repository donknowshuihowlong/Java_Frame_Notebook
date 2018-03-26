package crud;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import crud.dao.IStudentDao;
import crud.util.MyBatisUtil;


public class TestDemo2 {
	private IStudentDao dao;
	private SqlSession session;
	String path = "crud/SqlMapConfig.xml";
	boolean autoCommitOrNot = true;
	
	@Before
	public void setUp() {
		//这里把数据库修改设置为自动提交，方便测试
		session = MyBatisUtil.getSqlSession(path,autoCommitOrNot);
		//Mapper动态代理，需要使用session的getMapper方法获取接口实现类的动态代理对象
		dao = session.getMapper(IStudentDao.class);
	}
	@After
	public void tearDown() {
		//关闭SqlSession
		if(session != null) {
			session.close();
		}
	}
	@Test
	public void testinsertStudent() {
		//批量插入10个学生信息
		for(int i = 1;i < 11;i++) {
			dao.insertStudent(new Student("s_"+i,20+i,(double) Math.random()*100));
		}
	}
	
	@Test
	public void testinsertStudentCatchId() {
		//测试获取ID功能
		//插入xiaoming前 Student [id=null, name=xiaoming, age=18, score=80.0]
		//插入xiaoming后 Student [id=20, name=xiaoming, age=18, score=80.0]
		//ID在StudentDaoImpl里面执行insert方法的时候就生成了，与是否提交无关
		Student stu = new Student("xiaoming",18,80.0);
		System.out.println("插入xiaoming前 " + stu);
		dao.insertStudentCatchId(stu);
		System.out.println("插入xiaoming后 " + stu);
	}
	@Test
	public void testdeleteStudentById() {
		//删除xiaoming
		dao.deleteStudentById(31);
	}
	@Test
	public void testupdateStudent() {
		Student stu = new Student("xiaomei",20,88.9);
		stu.setId(10);
		dao.updateStudent(stu);
	}
	@Test
	public void testselectAllStudents() {
		List<Student> stus = dao.selectAllStudents();
		Iterator<Student> iterator = stus.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	//Mybatis的DAO查询的自动实现，默认调用的是selectOne()和selectList()
	//这个方法要使用selectMap()
	//注释掉
	/*
	@Test
	public void testselectStudentMap() {
		Map<String, Student> stusMap = dao.selectStudentMap();
		Set<Entry<String, Student>> entrySet = stusMap.entrySet();
		Iterator<Entry<String, Student>> iterator = entrySet.iterator();
		while(iterator.hasNext()) {
			Map.Entry<String, Student> entry = iterator.next();
			System.out.println("key = " + entry.getKey() 
			+ " value = " + entry.getValue());
		}
	}
	*/
	@Test
	public void testselectStudentById() {
		Student stu = dao.selectStudentById(10);
		System.out.println(stu);
	}
	
	//模糊查询
	@Test
	public void testselectStudentByName() {
		List<Student> stus = dao.selectStudentByName("s");
		for (Student student : stus) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testselectStudentByMap() {
		Student stu = dao.selectStudentById(15);
		Map<String,Object> map = new HashMap<String,Object>();
		//测试第1个就好
		map.put("studentId", 15);
		//map.put("student", stu);
		stu = dao.selectStudentByMap(map);
		System.out.println(stu);
	}
	
	//多查询条件无法整体接收问题的解决方法1
	//多个参数封装map
	@Test
	public void testselectStudentsByMap() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("nameCondition", "2");
		map.put("ageCondition", 22);
		List<Student> result = dao.selectStudentsByMap(map);
		for (Student student : result) {
			System.out.println(student);
		}
	}
	//多查询条件无法整体接收问题的解决方法2
	//通过参数索引#{index}逐个接收每个参数
	@Test
	public void testselectStudentsByConditions() {
		List<Student> stus = dao.selectStudentsByConditions("s", 22);
		for (Student stu : stus) {
			System.out.println(stu);
		}
	}
	
}
