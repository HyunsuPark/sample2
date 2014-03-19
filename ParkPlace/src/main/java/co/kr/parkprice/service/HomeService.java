package co.kr.parkprice.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class HomeService extends AbstractCommonService{

	public void saveContact(HashMap<String, String> map){
		this.getSqlMapClientTemplate().insert("contact.insertContact", map);
	}
}
