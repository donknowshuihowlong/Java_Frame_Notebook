package guanlian.pojo;

import java.util.Set;

public class Country {
	private Integer cid;
	private String cname;
	//一对多查询，一个国家对应多个人
	private Set<Person> persons;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<Person> getPersons() {
		return persons;
	}
	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}
	@Override
	public String toString() {
		return "Country [cid=" + cid + ", cname=" + cname + ", persons=" + persons + "]";
	}
	
}
