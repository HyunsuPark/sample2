package sample.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSessionFactory;

import common.db.SqlSessionFactoryManager;

public class SampleDao {
	
	SqlSessionFactory sqlMapper = SqlSessionFactoryManager.getSqlSessionFactory();
	
	public SampleDao() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * JOBS 테이블의 정보를 반환(검색키워드가 없으면 모두 반환)
	 * @param map
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getBoardCnt(){
		Object obj = null;
		obj = sqlMapper.openSession().selectOne("sample.query.Sample1.getBoardCnt");
		return (String)obj;
	}
	
	public ArrayList<HashMap<String, String>> getBoard(){
		ArrayList<HashMap<String, String>> list = null;
		list = (ArrayList)sqlMapper.openSession().selectList("sample.query.Sample1.getBoard");
		return list;
	}
	
	public int insertData(HashMap<String,String> map){
		int num = 0;
		num = sqlMapper.openSession(true).insert("sample.query.Sample1.insertBoard", map);
		return num;
	}

}
