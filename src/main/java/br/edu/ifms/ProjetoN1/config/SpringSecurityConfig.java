package br.edu.ifms.ProjetoN1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class SpringSecurityConfig {
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
		builder.inMemoryAuthentication()
		.withUser("luiz").password("{noop}luiz").roles("ADMIN")
		.and()
		.withUser("furlan").password("{noop}furlan").roles("USER");
	}
}
