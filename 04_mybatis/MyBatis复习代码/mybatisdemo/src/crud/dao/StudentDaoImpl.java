package crud.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import crud.Student;
import crud.util.MyBatisUtil;
/**
 * 这个Dao接口实现类本质工作：
 * 	通过SqlSession的API定位到文件的mapper的对应ID的SQL语句
 * 
 * 然而真正对DB的操作是通过框架用mapper中的SQL完成的
 * @author copywang
 *
 */
public class StudentDaoImpl implements IStudentDao {
	private SqlSession session;
	String path = "crud/SqlMapConfig.xml";
	
	@Override
	public void insertStudent(Student stu) {
		try {
			session = MyBatisUtil.getSqlSession(path);
			//4. 操作
			//去xml文件里面查找ID 为insertStudent 的SQL语句
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
	@Override
	public void insertStudentCatchId(Student stu) {
		try {
			session = MyBatisUtil.getSqlSession(path);
			//4. 操作
			session.insert("insertStudentCatchId", stu);
			//这里虽然未提交修改，但是其实ID已经生成了！
			//即使回滚，ID也已经被占用了！
			System.out.println("未提交，但是ID已经生成了！" + stu);
			//5. SqlSession提交
			session.commit();
		} finally {
			//6. 关闭SqlSession
			if(session != null) {
				session.close();
			}
		}
	}
	@Override
	public void deleteStudentById(Integer id) {
		try {
			session = MyBatisUtil.getSqlSession(path);
			//4. 操作
			session.delete("deleteStudentById", id);
			//5. SqlSession提交
			session.commit();
		} finally {
			//6. 关闭SqlSession
			if(session != null) {
				session.close();
			}
		}
	}
	@Override
	public void updateStudent(Student stu) {
		try {
			session = MyBatisUtil.getSqlSession(path);
			//4. 操作
			session.update("updateStudent", stu);
			//5. SqlSession提交
			session.commit();
		} finally {
			//6. 关闭SqlSession
			if(session != null) {
				session.close();
			}
		}
	}
	@Override
	public List<Student> selectAllStudents() {
		List<Student> stus = null;
		try {
			session = MyBatisUtil.getSqlSession(path);
			//4. 操作
			stus = session.selectList("selectAllStudents");
		} finally {
			//6. 关闭SqlSession
			if(session != null) {
				session.close();
			}
		}
		return stus;
	}
	@Override
	public Map<String, Student> selectStudentMap() {
		Map<String, Student> stusMap = null;
		try {
			session = MyBatisUtil.getSqlSession(path);
			//4. 操作
			//使用name属性作为key student对象作为map，每一个student作为1个Map.entry对象
			//key要保证唯一
			stusMap = session.selectMap("selectStudentMap", "name");
		} finally {
			//6. 关闭SqlSession
			if(session != null) {
				session.close();
			}
		}
		return stusMap;
	}
	@Override
	public Student selectStudentById(Integer id) {
		Student stu = null;
		try {
			session = MyBatisUtil.getSqlSession(path);
			stu = session.selectOne("selectStudentById",id);
		} finally {
			//6. 关闭SqlSession
			if(session != null) {
				session.close();
			}
		}
		return stu;
	}
	@Override
	public Student selectStudentByMap(Map<String, Object> map) {
		Student stu = null;
		try {
			session = MyBatisUtil.getSqlSession(path);
			stu = session.selectOne("selectStudentByMap", map);
		} finally {
			//6. 关闭SqlSession
			if(session != null) {
				session.close();
			}
		}
		return stu;
	}
	@Override
	public List<Student> selectStudentByName(String name) {
		List<Student> stus = null;
		try {
			session = MyBatisUtil.getSqlSession(path);
			//4. 操作
			stus = session.selectList("selectStudentByName",name);
		} finally {
			//6. 关闭SqlSession
			if(session != null) {
				session.close();
			}
		}
		return stus;
	}
}
