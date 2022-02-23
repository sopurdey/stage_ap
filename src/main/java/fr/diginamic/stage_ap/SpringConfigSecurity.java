package fr.diginamic.stage_ap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import fr.diginamic.stage_ap.providers.AppAuthProvider;
import fr.diginamic.stage_ap.services.UserService;

@Configuration
@EnableWebSecurity
public class SpringConfigSecurity extends WebSecurityConfigurerAdapter {
	
	String url = "http://localhost:8290";
	
	@Autowired
	UserService userDetailsService;

	@Bean
	public AuthenticationProvider getProvider() {
		AppAuthProvider provider = new AppAuthProvider();
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * J'autorise tous les accés à mon app web
		 */
		http.csrf().disable().authorizeRequests().anyRequest().permitAll();
		
	}

}
