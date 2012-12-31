package com.hael.beans;

import java.util.Arrays;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class RegistrationBean {
	
	private String username;
	private String password;
	private String passwordConfirm;
	
	private static final Logger log = LoggerFactory.getLogger(RegistrationBean.class);
	
	@Autowired
	private UserDetailsManager userDetailsManager;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void register() {
		
		//TODO: move all this to service layer
		GrantedAuthority userAuthority = new SimpleGrantedAuthority("ROLE_USER");
		Collection<? extends GrantedAuthority> authorities = Arrays.asList(userAuthority);

		//TODO: move this to faces validator
		if (! password.equals(passwordConfirm)) {
			FacesMessage error = new FacesMessage("Passwords do not match");
			error.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, error);
			return;
		}
		
		//TODO: move this to faces validator
		if (userDetailsManager.userExists(username)) {
			FacesMessage error = new FacesMessage("Username is already taken");
			error.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, error);
			return;
		}
		
		String hashedPassword = passwordEncoder.encode(password);
		log.debug("Hashed PW is {}", hashedPassword);
		
		
		UserDetails userDetails = new User(username, hashedPassword, false, true, true, true, authorities);
		userDetailsManager.createUser(userDetails);
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the passwordConfirm
	 */
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	/**
	 * @param passwordConfirm the passwordConfirm to set
	 */
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
}
