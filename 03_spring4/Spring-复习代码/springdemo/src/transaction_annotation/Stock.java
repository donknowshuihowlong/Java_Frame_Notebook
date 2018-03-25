package transaction_annotation;

public class Stock {
	private Integer id;
	private String sname;
	private Double count;
	public Stock(String sname, Double count) {
		this.sname = sname;
		this.count = count;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Double getCount() {
		return count;
	}
	public void setCount(Double count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Stock [id=" + id + ", sname=" + sname + ", count=" + count + "]";
	}
	
}
