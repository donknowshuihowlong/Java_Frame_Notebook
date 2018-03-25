package transaction_advisor;

public interface IAccountDao {
	void insert(Account account);
	void update(String aname,Double money);
	Account selectAccountByAname(String aname);
}
