package primary_3;

import org.junit.Test;

import primary_3.dao.IStudentDao;
import primary_3.dao.StudentDaoImpl;


public class TestDemo {
	@Test
	public void test1() {
		IStudentDao dao = new StudentDaoImpl();
		dao.insertStudent(new Student("小明",18,88.0));
	}
}
