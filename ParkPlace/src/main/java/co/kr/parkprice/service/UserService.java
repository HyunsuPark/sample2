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
		user.setEmail(param.getEmail());
		
		ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder();
		String encodePwd = passwordEncoder.encodePassword(param.getPassword(),
				null);
		user.setPassword(encodePwd);
		
		User userChk = new User();
		userChk.setId(param.getId());
		
		User resultUser = (User)this.getSqlMapClientTemplate().queryForObject("user.getUser", userChk);
		
		if(resultUser == null){
			this.getSqlMapClientTemplate().insert("user.insertUser", user);
			addRole(user);
			return "ok";
		}else{
			return "";
		}
	}
	
	public void addRole(User param){
		Role role = new Role();
		role.setId(param.getId());
		role.setRole("ROLE_USER");
		
		this.getSqlMapClientTemplate().insert("role.insertRole", role);
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
