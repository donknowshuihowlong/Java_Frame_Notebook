package transaction_bystock;

public interface IStockProcessService {
	//开户，创建账号
	void openAccount(Account account);
	//创建股票
	void openStock(Stock stock);
	//买股票
	void buyStock(String aname,String sname, Double money,Double count) throws StockException;
	//根据用户名获取账户
	Account findAccount(String aname);
	//根据股票名称获取股票信息
	Stock findStock(String sname);
}
