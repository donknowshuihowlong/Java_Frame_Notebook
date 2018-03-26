package guanlian.pojo;

public class Person {
	private Integer pid;
	private String pname;
	private Integer countryid;
	//<!-- 多表查询 多对一  多个人属于同一个国家-->
	private Country country;
	
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public Integer getCountryid() {
		return countryid;
	}
	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", countryid=" + countryid + ", country=" + country + "]";
	}
	
}
