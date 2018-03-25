package adi01;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//指定bean的id
@Component("student")
/*
下面这3个和Component是等效的，使用场景不同，方便扩展功能
@Repository --- 用于DAO实现类
@Service ---用于Service实现类
@Controller --- 用于Controller实现类
 */
//指定bean的作用范围
@Scope("singleton")
public class Student {
	//基本类型注入，直接在属性上注入不安全，破坏了封装性，开发中不使用此种方式
	//@value("xiaoming")
	private String name;
	private Integer age;
	//引用类型注入，这里写在属性，开发中写在setter方法上
	/* 
	 * 按照类型注入域属性@Autowired
	 * 如果有多个同样类型的，就无法注入
	 * @Autowired(required=false) 表示匹配失败，设置为null
	 */
	@Autowired
	/*
	 * 按照类型注入域属性@Qualifier
	 * 指定名称注入
	 */
	@Qualifier("school")
	/*
	 * 域属性注解@Resource
	 * 1. @Resource 不带参数，表示按照School去匹配Bean
	 * 2. @Resource(name="school")，查找name为school的属性注入
	 */
	@Resource(name="school")
	private School school;
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	public String getName() {
		return name;
	}
	//基本类型注入，在setter上使用
    @Value("xiaoming")
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	//基本类型注入，在setter上使用
	@Value("18")
	public void setAge(Integer age) {
		this.age = age;
	}
	//初始化方法和销毁方法
	@PostConstruct
	public void setUp() {
		System.out.println("Bean初始化完成后执行");
	}
	@PreDestroy
	public void tearDown() {
		System.out.println("Bean对象销毁前执行");
	}
}
