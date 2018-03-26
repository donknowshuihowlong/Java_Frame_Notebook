package primary_2.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory ssf;
	public static SqlSession getSqlSession(String configurationFilePath) {
		if(ssf==null) {
			try {
				InputStream in = Resources.getResourceAsStream(configurationFilePath);
				ssf = new SqlSessionFactoryBuilder().build(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ssf.openSession();
	}
}
