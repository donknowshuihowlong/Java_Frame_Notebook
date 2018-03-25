package beanAssemble.ba06;

public class UserServiceImpl implements IUserService {

	public UserServiceImpl() {
		System.out.println("getBean()首先调用的是无参构造");
	}

	@Override
	public void doSome() {
		System.out.println("doSome()");
	}

	@Override
	public void doOther() {
		System.out.println("doOther()");
	}
	
	@Override
	public void setUp() {
		System.out.println("初始化完毕后的行为");
	}
	
	@Override
	public void tearDown() {
		System.out.println("销毁前的行为");
	}
}
