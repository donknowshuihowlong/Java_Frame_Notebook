package beanAssemble.ba02;

public class ServiceFactory {
	/**
	 * IUserService工厂类
	 * @return
	 */
	public IUserService getUserService() {
		return new UserServiceImpl();
	}
}
