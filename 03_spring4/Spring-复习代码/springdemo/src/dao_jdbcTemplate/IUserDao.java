package dao_jdbcTemplate;

import java.util.List;

public interface IUserDao {
	//增加
	void insert(User user);
	//删除
	void delete(Integer id);
	//修改
	void update(User user);
	
	//根据ID查询用户名
	String selectUsernameByID(Integer id);
	//根据年龄查询用户名
	List<String> selectUsernameByAge(Integer age);
	//根据ID查询用户记录
	User selectUserById(Integer id);
	//查询所有记录
	List<User> selectAllUsers();
}
