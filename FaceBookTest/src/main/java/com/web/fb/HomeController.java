package com.web.fb;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth1.OAuth1Parameters;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	ConnectionFactoryLocator cFactoryLocator;
	
	OAuth2Operations auth2Operations;
	
	FacebookConnectionFactory connectionFactory;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(String code,HttpServletRequest req,HttpServletResponse res) {
		String accessToken = code;
		
		System.out.println(accessToken);
		
		AccessGrant accessGrant = auth2Operations.exchangeForAccess(accessToken, "http://localhost:8080/fb", null);
		Connection<Facebook> connection = connectionFactory.createConnection(accessGrant);
		
		System.out.println(connection);
		
		Facebook facebook = (Facebook)(connection != null ? connection.getApi() : new FacebookTemplate());
		
		FacebookProfile profile = facebook.userOperations().getUserProfile();
		
		System.out.println(profile.getUsername());
		
		return "home";
	}
	
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public void fb(HttpServletRequest req,HttpServletResponse res) throws IOException {
		connectionFactory = (FacebookConnectionFactory) cFactoryLocator.getConnectionFactory("facebook");
		
		auth2Operations = connectionFactory.getOAuthOperations();
		OAuth2Parameters parameters = new OAuth2Parameters();
		parameters.setScope("user_about_me");
		parameters.setRedirectUri("http://localhost:8080/fb");
		String authorizeUrl = auth2Operations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, parameters);
		res.sendRedirect(authorizeUrl);
	}
	
}
