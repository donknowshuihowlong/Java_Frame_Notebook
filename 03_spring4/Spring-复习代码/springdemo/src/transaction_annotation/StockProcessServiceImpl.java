package transaction_annotation;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

public class StockProcessServiceImpl implements IStockProcessService {
	
	private IAccountDao adao;
	private IStockDao sdao;
	
	private TransactionTemplate tt;
	
	public TransactionTemplate getTt() {
		return tt;
	}

	public void setTt(TransactionTemplate tt) {
		this.tt = tt;
	}

	public IAccountDao getAdao() {
		return adao;
	}

	public void setAdao(IAccountDao adao) {
		this.adao = adao;
	}

	public IStockDao getSdao() {
		return sdao;
	}

	public void setSdao(IStockDao sdao) {
		this.sdao = sdao;
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void openAccount(Account account) {
		adao.insert(account);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void openStock(Stock stock) {
		sdao.insert(stock);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=StockException.class)
	public void buyStock(String aname,String sname, Double money,Double count) throws StockException {
		adao.update(aname,money);
		//在这里搞一个异常
//		if (true) {
//			throw new StockException();
//		}
		sdao.update(sname,count);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Account findAccount(String aname) {
		return adao.selectAccountByAname(aname);
	}

	@Override
	public Stock findStock(String sname) {
		return sdao.selectStockBySname(sname);
	}

}
