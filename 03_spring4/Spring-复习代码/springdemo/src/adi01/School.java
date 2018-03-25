package adi01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("school")
public class School {
	private String schoolName;
	@Value("xx小学")
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
}
