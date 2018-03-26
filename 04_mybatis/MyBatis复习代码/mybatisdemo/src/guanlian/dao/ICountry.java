package guanlian.dao;

import guanlian.pojo.Country;

public interface ICountry {
	Country selectCountryById(Integer cid);
	Country selectCountryById2(Integer cid);
}
