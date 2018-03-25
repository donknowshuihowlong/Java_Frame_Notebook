package beanAssemble.ba07;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 待增强的Bean类
 * @author copywang
 *
 */
public class StudentServiceImpl implements IService,BeanNameAware,BeanFactoryAware,InitializingBean,DisposableBean{
	private String name;
	public StudentServiceImpl() {
		System.out.println("getBean()首先调用的是无参构造");
	}

	@Override
	public void doSome() {
		System.out.println(this.getClass().getSimpleName() + "doSome() 真实业务");
	}

	@Override
	public void doOther() {
		System.out.println(this.getClass().getSimpleName() + "doOther()");
	}

	@Override
	public void setBeanName(String beanName) {
		// TODO Auto-generated method stub
		System.out.println("BeanNameAware接口的setBeanName()" + "可以获得在XML中配置的Bean ID 是" + beanName);
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("DisposableBean接口的destroy()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("InitializingBean接口的afterPropertiesSet() 对象已经初始化完毕了！");
	}

	@Override
	public void setBeanFactory(BeanFactory bf) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("BeanFactoryAware接口的setBeanFactory()" + "可以获得BeanFactory的对象是：" + bf);
	}
	public void setUp() {
		System.out.println("init-method xml中的创建后行为");
		
	}
	public void tearDown() {
		System.out.println("destroy-method xml的销毁前行为");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("为name属性注入值");
		this.name = name;
	}
}
