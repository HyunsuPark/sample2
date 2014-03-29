package co.kr.parkprice.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;

public abstract class AbstractCommonService extends SqlMapClientDaoSupport{
	
	protected static final Logger logger = LoggerFactory.getLogger(AbstractCommonService.class);
	
	@Resource(name = "sqlMapClient")
	public void setSuperSqlMapClient(SqlMapClient sqlMapClient) {
		super.setSqlMapClient(sqlMapClient);
	}
	
}
