package common.db;

import java.io.IOException;
import java.io.Reader;
import java.util.logging.Logger;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * SqlSessionFactory 인스턴스를 싱글턴으로 반환함
 *
 */
public class SqlSessionFactoryManager {

	private static final SqlSessionFactory sqlMapper;
	
	static{
		String resource = "common/config/SqlMapConfig.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlMapper = new SqlSessionFactoryBuilder().build(reader);
	}
	
		
//	SqlSession session = sqlMapper.openSession();
//	session.selectList("org.mybatis.example.BlogMapper.selectBlog", null);
	
	/**
	 * 
	 * @return SqlSessionFactory 인스턴스를 반환
	 */
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlMapper;   
	}

	
}
