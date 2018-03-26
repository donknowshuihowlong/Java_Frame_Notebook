package primary.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import primary.Student;

public class StudentDaoImpl implements IStudentDao {
	private SqlSession session;
	@Override
	public void insertStudent(Student stu) {
		//1. 读取主配置文件SqlMapConfig.xml
		try {
			InputStream in = Resources.getResourceAsStream("primary/SqlMapConfig.xml");
			//2. 创建SqlSessionFactory对象
			/*
			 * ssf线程安全
			 * SqlSessionFactoryBuilder在创建ssf之后就被销毁，作为方法内局部对象
			 * build方法创建好ssf之后，会自动关闭in流
			 */
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
			//3. 创建SqlSession对象
			/*
			 * openSession(true) 自动提交
			 * 默认为false，做了以下几件事情
			 * 1. 加载主配置文件
			 * 2. 创建执行器对象（用于执行映射文件中的SQL语句）
			 * 3. 初始化标志变量dirty为false表明数据库未修改
			 * 4. 关闭事务自动提交功能
			 * 
			 */
			session = ssf.openSession();
			//4. 操作
			/*
			 * 常用方法
			 * ===底层调用的是update(statement, parameter)方法===
			 * insert
			 * delete
			 * update
			 * ==============================================
			 * select
			 * selectList
			 * selectMap
			 * selectOne
			 * commit
			 * rollback
			 * 
			 */
			session.insert("insertStudent", stu);
			//5. SqlSession提交
			session.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//6. 关闭SqlSession
			if(session != null) {
				session.close();
			}
		}
		
	}

}
