package dao_jdbcTemplate;

import java.util.List;

public class UserServiceImpl implements IUserService {
	private IUserDao dao;
	
	public IUserDao getDao() {
		return dao;
	}

	public void setDao(IUserDao dao) {
		this.dao = dao;
	}

	@Override
	public void add(User user) {
		dao.insert(user);
	}

	@Override
	public void remove(Integer id) {
		dao.delete(id);
	}

	@Override
	public void modify(User user) {
		dao.update(user);
	}

	@Override
	public String findUsernameById(Integer id) {
		return dao.selectUsernameByID(id);
	}

	@Override
	public List<String> findUsernameByAge(Integer age) {
		return dao.selectUsernameByAge(age);
	}

	@Override
	public User findUserById(Integer id) {
		return dao.selectUserById(id);
	}

	@Override
	public List<User> findAllUser() {
		return dao.selectAllUsers();
	}

}
