package beanAssemble.ba01;

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

}
