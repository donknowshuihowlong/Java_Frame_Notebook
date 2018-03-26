package crud.dao;

import java.util.List;
import java.util.Map;

import crud.Student;

public interface IStudentDao {
	//增
	void insertStudent(Student stu);
	void insertStudentCatchId(Student stu);
	//删
	void deleteStudentById(Integer id);
	//改
	void updateStudent(Student stu);
	//查
	//查询所有
	List<Student> selectAllStudents();
	Map<String,Student> selectStudentMap();
	
	//查询指定，返回单个对象
	Student selectStudentById(Integer id);
	Student selectStudentByMap(Map<String,Object> map);
	
	//根据姓名查询
	List<Student> selectStudentByName(String name);
	
	
	//多查询条件无法整体接收问题的解决方法1
	//多个参数封装map
	List<Student> selectStudentsByMap(Map<String,Object> map);
	//多查询条件无法整体接收问题的解决方法2
	//通过参数索引#{index}逐个接收每个参数
	List<Student> selectStudentsByConditions(String name,Integer age);
	
	//以下是测试动态SQL
	List<Student> selectStudentsIf(Student stu);
	List<Student> selectStudentsWhere(Student stu);
	List<Student> selectStudentsChoose(Student stu);
	
	List<Student> selectStudentsForeachArray(Object[] studentIds);
	List<Student> selectStudentsForeachList(List<Integer> studentIds);
	List<Student> selectStudentsForeachListStu(List<Student> student);
}
