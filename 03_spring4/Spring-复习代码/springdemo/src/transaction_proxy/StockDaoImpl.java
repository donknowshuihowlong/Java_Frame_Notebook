package transaction_proxy;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class StockDaoImpl extends JdbcDaoSupport implements IStockDao {

	@Override
	public void insert(Stock stock) {
		String sql = "insert into t_stock(sname,count) values(?,?)";
		this.getJdbcTemplate().update(sql,stock.getSname(),stock.getCount());
	}

	@Override
	public void update(String sname,Double count) {
		String sql = "update t_stock set count=count+? where sname=?";
		this.getJdbcTemplate().update(sql,count,sname);
	}

	@Override
	public Stock selectStockBySname(String sname) {
		String sql = "select * from t_stock where sname=?";
		return this.getJdbcTemplate().queryForObject(sql, Stock.class);
	}

}
