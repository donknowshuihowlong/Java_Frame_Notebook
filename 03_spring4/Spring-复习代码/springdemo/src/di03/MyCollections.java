package di03;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MyCollections {
	private String[] strs;
	private List<Student> students;
	private Set<String> mySet;
	private Map<String,Integer> myMap;
	private Properties myPro;
	@Override
	public String toString() {
		return "MyCollections [strs=" + Arrays.toString(strs) + ", students=" + students + ", mySet=" + mySet
				+ ", myMap=" + myMap + ", myPro=" + myPro + "]";
	}
	public String[] getStrs() {
		return strs;
	}
	public void setStrs(String[] strs) {
		this.strs = strs;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Set<String> getMySet() {
		return mySet;
	}
	public void setMySet(Set<String> mySet) {
		this.mySet = mySet;
	}
	public Map<String, Integer> getMyMap() {
		return myMap;
	}
	public void setMyMap(Map<String, Integer> myMap) {
		this.myMap = myMap;
	}
	public Properties getMyPro() {
		return myPro;
	}
	public void setMyPro(Properties myPro) {
		this.myPro = myPro;
	}
	
}
