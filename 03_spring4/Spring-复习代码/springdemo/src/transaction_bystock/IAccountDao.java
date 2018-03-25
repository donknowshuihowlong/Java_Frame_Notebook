package transaction_bystock;

public interface IAccountDao {
	void insert(Account account);
	void update(String aname,Double money);
	Account selectAccountByAname(String aname);
}
