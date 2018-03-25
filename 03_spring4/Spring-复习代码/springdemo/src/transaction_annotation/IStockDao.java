package transaction_annotation;

public interface IStockDao {
	void insert(Stock stock);
	void update(String sname,Double count);
	Stock selectStockBySname(String sname);
}
