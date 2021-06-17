package com.springsecurity.controllers.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// add our users for in memory authentication

		User.UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication()
			.withUser(users.username("azhar").password("azhar123").roles("EMPLOYEE","ADMIN"))
			.withUser(users.username("test").password("test123").roles("EMPLOYEE"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login").hasAnyRole()
				.antMatchers("/admin").hasRole("ADMIN")
				.and()
				.exceptionHandling().accessDeniedPage("/accessDenied")
				.and()
				.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
				.and()
				.logout()
				.permitAll()
				.and()
				.csrf().disable();
	}
}
