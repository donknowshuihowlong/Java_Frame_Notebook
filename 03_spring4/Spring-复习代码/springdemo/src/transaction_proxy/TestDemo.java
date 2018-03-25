package transaction_proxy;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
	private IStockProcessService service;
	@Before
	public void setUp() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:transaction_proxy/applicationContext.xml");
		//注意这里是代理对象
		service = (IStockProcessService) ac.getBean("myServiceProxy");
	}
	@Test
	public void test1() {
		Account account = new Account("小明",1000.0);
		service.openAccount(account);
		Stock stock = new Stock("茅台",0.0);
		service.openStock(stock);
	}
	@Test
	public void test2() throws StockException {
		service.buyStock("小明", "茅台", 100.0, 200.0);
	}
}
