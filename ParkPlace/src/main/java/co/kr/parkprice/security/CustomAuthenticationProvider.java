package co.kr.parkprice.security;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import co.kr.parkprice.model.Role;
import co.kr.parkprice.model.User;
import co.kr.parkprice.service.UserService;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	private static Logger logger = Logger
			.getLogger(CustomAuthenticationProvider.class);

	@Autowired
	private UserService service;
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {

		String principal = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		// 데이타 베이스에 암호화되어 들어간 데이터와 비교하기 위해 암호화
		ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder();
		String encodePassword = passwordEncoder.encodePassword(password, null);

		if (!isAuthenticatedUser(principal, encodePassword)) {
			throw new BadCredentialsException("Username does not match for "
					+ principal);
		}

		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		roles.add(new SimpleGrantedAuthority(checkRole(principal)));

		return new UsernamePasswordAuthenticationToken(principal, password,
				roles);
	}

	
	public String checkRole(String principal) {
		String resultRole = "";
		User user = new User();
		user.setId(principal);
		
		Role role = new Role();
		
		try {
			role.setId(user.getId());
			role = service.getRole(role);

			if (role.getRole().equals("")) {
//				resultRole = "ROLE_NONE";
				resultRole = "ADMIN";
			} else {
				resultRole = role.getRole();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultRole;
	}

	public boolean isAuthenticatedUser(String principal, String password) {
		User vo = new User();

		vo.setId((String) principal);
		vo.setPassword(password);
		
		User resultVo = null;
		try {
			resultVo = service.getUser(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultVo != null ? true : false;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
