package guanlian.pojo;

import java.util.Set;

/*
 * 数据库表定义	newslabel
 * =================
 * id 	name 	pid
 * 1	娱乐新闻	0
 * 2	体育新闻	0
 * 3	NBA		2
 * 4	CBA		2
 * 5	火箭		3
 * 6	湖人		3
 * 7	北京		4
 * 8	广东		4
 * 9	青岛		4
 * 10	港台明星	1
 * 11	内地影视	1
 * =================
 * pid为0代表是主栏目，没有父栏目
 * pid为id的外键，比如湖人属于NBA属于体育新闻
 */
public class NewsLabel {
	private Integer id;
	private String name;
	//关联属性，指定子栏目，多方，演示一对多
	private Set<NewsLabel> children;
	
	//演示多对一
	private NewsLabel parent;
	
	public NewsLabel getParent() {
		return parent;
	}
	public void setParent(NewsLabel parent) {
		this.parent = parent;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<NewsLabel> getChildren() {
		return children;
	}
	public void setChildren(Set<NewsLabel> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "NewsLabel [id=" + id + ", name=" + name + ", children=" + children + "]";
	}
	
}
