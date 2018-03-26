package guanlian.dao;

import java.util.List;

import guanlian.pojo.Person;

public interface IPerson {
	List<Person> selectPersonByCountryId(Integer countryid);
	//<!-- 多表查询 多对一  多个人属于同一个国家-->
	Person selectPersonById(Integer pid);
}
