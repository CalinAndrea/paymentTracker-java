package payment.tracker.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

import payment.tracker.filters.CORSFilter;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = { "payment.tracker.controllers" })
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final String CONSOLE_URL = "/console/**";

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().and().addFilterBefore(new CORSFilter(),
				ChannelProcessingFilter.class);
		http.exceptionHandling();
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
}
