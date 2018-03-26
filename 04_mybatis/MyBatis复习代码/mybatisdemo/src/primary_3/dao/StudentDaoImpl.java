package primary_3.dao;

import org.apache.ibatis.session.SqlSession;
import primary_3.Student;
import primary_3.util.MyBatisUtil;

public class StudentDaoImpl implements IStudentDao {
	private SqlSession session;
	@Override
	public void insertStudent(Student stu) {
		String path = "primary_3/SqlMapConfig.xml";
		try {
			session = MyBatisUtil.getSqlSession(path);
			//4. 操作
			//如果mapper里面的SQL的ID相同，在调用的时候直接指定namespace
			session.insert("primary_3.mapper2.insertStudent", stu);
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
