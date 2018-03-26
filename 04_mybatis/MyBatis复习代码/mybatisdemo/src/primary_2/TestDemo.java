package primary_2;

import org.junit.Test;

import primary_2.dao.IStudentDao;
import primary_2.dao.StudentDaoImpl;


public class TestDemo {
	@Test
	public void test1() {
		IStudentDao dao = new StudentDaoImpl();
		dao.insertStudent(new Student("小明",18,99.0));
	}
}
