package adi02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("school")
public class School {
	private String schoolName;

	public String getSchoolName() {
		return schoolName;
	}
//	@Value("xx小学")
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	@Override
	public String toString() {
		return "School [schoolName=" + schoolName + "]";
	}
	
}
