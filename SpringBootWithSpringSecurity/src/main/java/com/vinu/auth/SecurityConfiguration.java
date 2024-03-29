package com.vinu.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.vinu.model.User;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure( AuthenticationManagerBuilder auth ) throws Exception {
        auth
                .userDetailsService( this.userDetailsService )
                .passwordEncoder( User.PASSWORD_ENCODER );
    }

    @Override
    protected void configure( HttpSecurity http ) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( "*.js" ).permitAll()
                .antMatchers("/test").anonymous()
                .antMatchers("/v1/**").authenticated()
                .and()
                .formLogin()
                .successHandler( ( httpServletRequest, httpServletResponse, authentication ) -> {
                    //do not redirect after successful login
                } ).permitAll()
                .and()
                .csrf().disable()
                .logout().logoutSuccessUrl( "/" );
        
    }
    
    
    
    @Override
	public void configure(WebSecurity web) throws Exception {
    	  web.ignoring().antMatchers("/v1/registerUser");
	}

	/*@Bean
    CorsConfigurationSource corsConfigurationSource()
    {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }*/

}
