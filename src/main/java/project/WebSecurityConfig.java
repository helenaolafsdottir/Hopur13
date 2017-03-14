package project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/myPage").access("hasRole('ROLE_USER')")
				.antMatchers("/m/**").permitAll()
				.anyRequest().permitAll()
				.and()
			.formLogin()
				.loginPage("/login").usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/myPage")
				.permitAll()
				.and()
			.logout().logoutSuccessUrl("/login?logout")
				.permitAll()
			.and()
				.csrf().disable();
	}
			
	
/*	 @Configuration
	    @Order(1)
	    public static class ApiWebSecurityConfig extends WebSecurityConfigurerAdapter{
	    	@Override
	    	protected void configure(HttpSecurity http) throws Exception {
	            http
             .antMatcher("/m/**")
             .authorizeRequests()
             	.antMatchers("/m/").permitAll()
                 .anyRequest().authenticated()
                 .and()
             .httpBasic();	
	    	}
	    	
	    }*/
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
	
	
}
