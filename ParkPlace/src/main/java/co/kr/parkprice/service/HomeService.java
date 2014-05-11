package co.kr.parkprice.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import co.kr.parkprice.model.Member;
import co.kr.parkprice.model.Parking;
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
	
	public ArrayList<Member> getMember(Member member){
		return (ArrayList<Member>)this.getSqlMapClientTemplate().queryForList("member.getMember",member); 
	}
	
	public ArrayList<Parking> getParking(Parking parking){
		return (ArrayList<Parking>)this.getSqlMapClientTemplate().queryForList("parking.getParking",parking); 
	}
	
	public void delParking(Parking parking){
		Object obj = this.getSqlMapClientTemplate().delete("parking.deleteParking",parking);
	}
	
	public void insParking(Parking parking){
		Object obj = this.getSqlMapClientTemplate().insert("parking.insertParking",parking);
	}
	
	public void udtParking(Parking parking){
		Object obj = this.getSqlMapClientTemplate().update("parking.updateParking",parking);
	}
}
