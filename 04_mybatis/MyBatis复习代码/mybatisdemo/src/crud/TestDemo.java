package crud;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import crud.dao.IStudentDao;
import crud.dao.StudentDaoImpl;


public class TestDemo {
	private IStudentDao dao;
	@Before
	public void setUp() {
		dao = new StudentDaoImpl();
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
		dao.deleteStudentById(20);
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
}
