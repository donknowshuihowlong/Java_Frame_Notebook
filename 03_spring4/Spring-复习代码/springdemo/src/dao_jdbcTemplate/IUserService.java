package dao_jdbcTemplate;

import java.util.List;

public interface IUserService {
	//增加用户
	void add(User user);
	//删除用户
	void remove(Integer id);
//	修改用户
	void modify(User user);
//  根据ID查找用户名
	String findUsernameById(Integer id);
//	根据年龄查找用户名
	List<String> findUsernameByAge(Integer age);
//	根据ID查找用户记录
	User findUserById(Integer id);
//	返回所有用户信息
	List<User> findAllUser();
}
