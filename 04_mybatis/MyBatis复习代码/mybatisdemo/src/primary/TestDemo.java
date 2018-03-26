package primary;

import org.junit.Test;

import primary.dao.IStudentDao;
import primary.dao.StudentDaoImpl;

public class TestDemo {
	@Test
	public void test1() {
		IStudentDao dao = new StudentDaoImpl();
		dao.insertStudent(new Student("小明",18,99.0));
	}
}
