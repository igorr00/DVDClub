package main.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/user/**").permitAll();
		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/actor/**").permitAll();
		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/director/**").permitAll();
		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/filmStudio/**").permitAll();
		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/film/**").permitAll();
		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/marketplace/**").permitAll();
		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/dvd/**").permitAll();
		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/genre/**").permitAll();
		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/news/**").permitAll();
		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/specialOffer/**").permitAll();
		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/rating/**").permitAll();
		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/purchase/**").permitAll();
	}
	
}
