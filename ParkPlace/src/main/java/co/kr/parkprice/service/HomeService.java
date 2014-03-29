package co.kr.parkprice.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import co.kr.parkprice.model.Registration;

@Service
public class HomeService extends AbstractCommonService{

	protected static final Logger logger = LoggerFactory.getLogger(HomeService.class);
	
	public void saveRegi(Registration regi){
		Object obj = this.getSqlMapClientTemplate().insert("registration.insertRegi", regi); 
	}
	
	public ArrayList<Registration> getRegi(Registration regi){
		return (ArrayList<Registration>)this.getSqlMapClientTemplate().queryForList("registration.getRegistration", regi); 
	}
	
}
