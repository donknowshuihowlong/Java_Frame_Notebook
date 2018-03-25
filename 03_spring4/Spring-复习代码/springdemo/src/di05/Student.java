package di05;

public class Student {
	private String stuName;
	private Integer stuAge;
	private School stuSchool;
	
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public School getStuSchool() {
		return stuSchool;
	}
	public void setStuSchool(School stuSchool) {
		this.stuSchool = stuSchool;
	}
	public Integer getStuAge() {
		return stuAge;
	}
	public void setStuAge(Integer stuAge) {
		this.stuAge = stuAge;
	}
	@Override
	public String toString() {
		return "Student [stuName=" + stuName + ", stuAge=" + stuAge + ", stuSchool=" + stuSchool + "]";
	}
	
}
