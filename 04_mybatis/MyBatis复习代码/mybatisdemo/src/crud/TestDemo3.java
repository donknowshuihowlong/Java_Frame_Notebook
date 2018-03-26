package crud;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import crud.dao.IStudentDao;
import crud.util.MyBatisUtil;


public class TestDemo3 {
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
	//用来测试动态SQL
	@Test
	public void testselectStudentsIf() {
		//无查询条件时
		dao.selectStudentsIf(new Student());
		//只有名字时
		dao.selectStudentsIf(new Student("xiaoming"));
		//名字为空
		dao.selectStudentsIf(new Student(""));
		//只有年龄
		dao.selectStudentsIf(new Student("",25));
	}
	@Test
	public void testselectStudentsWhere() {
		//无查询条件时
		dao.selectStudentsWhere(new Student());
		//只有名字时
		dao.selectStudentsWhere(new Student("xiaoming"));
		//名字为空
		dao.selectStudentsWhere(new Student(""));
		//只有年龄
		dao.selectStudentsWhere(new Student("",25));
	}
	@Test
	public void testselectStudentsChoose() {
		//无查询条件时
		dao.selectStudentsChoose(new Student());
		//只有名字时
		dao.selectStudentsChoose(new Student("xiaoming"));
		//名字为空
		dao.selectStudentsChoose(new Student(""));
		//只有年龄
		dao.selectStudentsChoose(new Student("",25));
	}
	@Test
	public void testselectStudentsForeachArray() {
		List<Student> stus = dao.selectStudentsForeachArray(new Object[] {32,33,34});
		for (Student student : stus) {
			System.out.println(student);
		}
	}
	@Test
	public void testselectStudentsForeachList() {
		List<Integer> stuIds = new ArrayList<Integer>();
		stuIds.add(32);
		stuIds.add(33);
		stuIds.add(34);
		List<Student> list = dao.selectStudentsForeachList(stuIds);
		for (Student stu : list) {
			System.out.println(stu);
		}
	}
	@Test
	public void testselectStudentsForeachListStu() {
		List<Student> stuIds = new ArrayList<Student>();
		Student student1 = new Student();
		Student student2 = new Student();
		Student student3 = new Student();
		student1.setId(32);;
		student2.setId(33);;
		student3.setId(34);;
		stuIds.add(student1);
		stuIds.add(student2);
		stuIds.add(student3);
		List<Student> list = dao.selectStudentsForeachListStu(stuIds);
		for (Student stu : list) {
			System.out.println(stu);
		}
	}
}
