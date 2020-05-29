package com.cschoolproject.InvestmentPanel2.Security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private DataSource userRepo;
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth
//		.jdbcAuthentication()
//			.dataSource(userRepo)
//			.withUser("admin").password("{noop}Admin1").roles("USER");
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("kontakt").permitAll()
			.antMatchers("index").permitAll()
			.antMatchers("registration").permitAll()
			.anyRequest().authenticated()
		.and()
			.formLogin()
				.loginPage("/loginform")
				.permitAll();
	}
}
