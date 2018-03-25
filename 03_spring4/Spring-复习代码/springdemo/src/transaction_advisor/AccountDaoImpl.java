package transaction_advisor;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

	@Override
	public void insert(Account account) {
		String sql = "insert into t_account(aname,balance) values(?,?)";
		this.getJdbcTemplate().update(sql, account.getAname(),account.getBalance());
	}

	@Override
	public void update(String aname,Double money) {
		String sql = "update t_account set balance=balance-? where aname=?";
		this.getJdbcTemplate().update(sql,money,aname);
	}

	@Override
	public Account selectAccountByAname(String aname) {
		String sql = "select * from t_account where aname=?";
		return this.getJdbcTemplate().queryForObject(sql, Account.class);
	}

}
