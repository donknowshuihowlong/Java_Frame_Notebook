package beanAssemble.ba03;

public class ServiceFactory {
	/**
	 * IUserService静态工厂类
	 * @return
	 */
	public static IUserService getUserService() {
		return new UserServiceImpl();
	}
}
