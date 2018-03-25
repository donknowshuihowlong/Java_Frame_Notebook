package di08;

public class Teacher extends ABase {
	private String name;
	private Integer Age;
	private String department;
	private String school;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", Age=" + Age + ", department=" + department + ", school=" + school + "]";
	}
	public Integer getAge() {
		return Age;
	}
	public void setAge(Integer age) {
		Age = age;
	}
}
