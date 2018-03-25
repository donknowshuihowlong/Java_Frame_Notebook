package di02_1;

public class Student {
	private String name;
	private Integer age;
	private School school;
	
	public Student() {
	}

	//构造注入使用的构造方法
	public Student(String name, Integer age, School school) {
		this.name = name;
		this.age = age;
		this.school = school;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", school=" + school + "]";
	}


	public School getSchool() {
		return school;
	}


	public void setSchool(School school) {
		this.school = school;
	}
}
