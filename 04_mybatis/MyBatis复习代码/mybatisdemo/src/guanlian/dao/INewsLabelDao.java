package guanlian.dao;

import java.util.List;

import guanlian.pojo.NewsLabel;

public interface INewsLabelDao {
	/*
	 * 一对多的方式处理：2个应用场景
	 * 	1. 查询出指定栏目的所有子孙栏目 --- 网页点击某主类目，然后进入到子类目下，可以看到子孙类目
	 * 	2. 查询出指定栏目以及所有子孙栏目 --- 鼠标悬停，可以看到子孙类目
	 */
	
	//1. 查询出指定栏目的所有子孙栏目
	List<NewsLabel> selectChildrenByParentId(Integer pid);
	//2. 查询出指定栏目以及所有子孙栏目
	NewsLabel selectNewsLabelById(Integer pid);
	
	/*
	 * 多对一的处理方式
	 * 应用场景：网页上显示当前页面的站内地址
	 */
	NewsLabel selectParentByParentId(Integer pid);
}
