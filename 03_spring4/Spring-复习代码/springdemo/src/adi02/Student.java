package adi02;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("student")
public class Student {
	private String stuName;
	private Integer stuAge;
	private School stuSchool;
	
	public String getStuName() {
		return stuName;
	}
//	@Value("xiaoming")
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public School getStuSchool() {
		return stuSchool;
	}
//	@Resource(name="school")
	public void setStuSchool(School stuSchool) {
		this.stuSchool = stuSchool;
	}
	public Integer getStuAge() {
		return stuAge;
	}
//	@Value("18")
	public void setStuAge(Integer stuAge) {
		this.stuAge = stuAge;
	}
	@Override
	public String toString() {
		return "Student [stuName=" + stuName + ", stuAge=" + stuAge + ", stuSchool=" + stuSchool + "]";
	}
	
}
