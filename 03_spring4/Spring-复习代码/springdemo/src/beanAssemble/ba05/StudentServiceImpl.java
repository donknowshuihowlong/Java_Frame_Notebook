package beanAssemble.ba05;
/**
 * 待增强的Bean类
 * @author copywang
 *
 */
public class StudentServiceImpl implements IService {

	public StudentServiceImpl() {
		//System.out.println("getBean()首先调用的是无参构造");
	}

	@Override
	public void doSome() {
		System.out.println(this.getClass().getSimpleName() + "doSome()");
	}

	@Override
	public void doOther() {
		System.out.println(this.getClass().getSimpleName() + "doOther()");
	}

}
