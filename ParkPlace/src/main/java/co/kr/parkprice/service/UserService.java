package co.kr.parkprice.service;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import co.kr.parkprice.model.Role;
import co.kr.parkprice.model.User;

@Service
public class UserService extends AbstractCommonService{
	public String addUser(User param){
		User user = new User();
		user.setId(param.getId());
		
		ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder();
		String encodePwd = passwordEncoder.encodePassword(param.getPassword(),
				null);
		user.setPassword(encodePwd);
		
		User resultUser = (User)this.getSqlMapClientTemplate().queryForObject("user.getUser", user);
		
		if(resultUser == null){
			this.getSqlMapClientTemplate().insert("user.insertUser", user);
			return "ok";
		}else{
			return "이미 존재하는 사용자입니다.";
		}
	}
	
	public User getUser(User user){
		User data = (User)this.getSqlMapClientTemplate().queryForObject("user.getUser", user);
		
		return data;
	}
	
	public Role getRole(Role role){
		Role data = (Role)this.getSqlMapClientTemplate().queryForObject("role.getRole", role);
		
		return data;
	}
}
