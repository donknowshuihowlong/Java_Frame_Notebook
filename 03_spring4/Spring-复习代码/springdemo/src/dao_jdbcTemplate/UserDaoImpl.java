package dao_jdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserDaoImpl extends JdbcDaoSupport implements IUserDao {

	@Override
	public void insert(User user) {
		String sql = "insert into t_user(username,age) values(?,?)";
		this.getJdbcTemplate().update(sql,user.getUsername(),user.getAge());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from t_user where id=?";
		this.getJdbcTemplate().update(sql,id);
	}

	@Override
	public void update(User user) {
		String sql = "update t_user set username=?,age=? where id=?";
		this.getJdbcTemplate().update(sql,user.getUsername(),user.getAge(),user.getId());
	}

	@Override
	public String selectUsernameByID(Integer id) {
		String sql = "select username from t_user where id=?";
		return this.getJdbcTemplate().queryForObject(sql, String.class,id);
	}

	@Override
	public List<String> selectUsernameByAge(Integer age) {
		String sql = "select username from t_user where age=?";
		return this.getJdbcTemplate().queryForList(sql,String.class,age);
	}

	@Override
	public User selectUserById(Integer id) {
		String sql = "select id,username,age from t_user where id=?";
		return this.getJdbcTemplate().queryForObject(sql, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setAge(rs.getInt("age"));
				return u;
			}
			
		},id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectAllUsers() {
		String sql = "select * from t_user";
		return (List<User>) this.getJdbcTemplate().query(sql, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setAge(rs.getInt("age"));
				return u;
			}
			
		});
	}
}
