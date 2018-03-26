package primary_2.dao;

import org.apache.ibatis.session.SqlSession;
import primary_2.Student;
import primary_2.util.MyBatisUtil;

public class StudentDaoImpl implements IStudentDao {
	private SqlSession session;
	@Override
	public void insertStudent(Student stu) {
		String path = "primary_2/SqlMapConfig.xml";
		try {
			session = MyBatisUtil.getSqlSession(path);
			//4. 操作
			session.insert("insertStudent", stu);
			//5. SqlSession提交
			session.commit();
		} finally {
			//6. 关闭SqlSession
			if(session != null) {
				session.close();
			}
		}
	}
}
