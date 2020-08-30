package com.cuarentena.web.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import com.cuarentena.web.services.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter{
	
	@Resource
	private UserDetailsServiceImpl userDetailsService;
	
	@Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.userDetailsService(userDetailsService);
        http.csrf().disable();
        http.rememberMe().key("remember-me").tokenValiditySeconds(120000); //2 min
        http.formLogin().loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/");
        http.logout().logoutSuccessUrl("/login");
        http.authorizeRequests()
        
        		/***********Todos los usuarios ***********************************/
                .antMatchers("/").permitAll()
        		.antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll();
//                .antMatchers("/user/resetPassword").permitAll()
//                .antMatchers("/resetPassword").permitAll()
//		        .antMatchers("/generatePassword").permitAll()
//                .antMatchers("/").authenticated()
//                .antMatchers("/clear-password").authenticated()
//		        .antMatchers("/new-password").authenticated()
//		        .antMatchers("/example/**").permitAll()
		        
		        /***********Usuario sucursal o validacion *************************/
//		        .antMatchers("/branch/**").hasRole("BRANCH")
//		        .antMatchers("/user/register/client").hasAnyRole("BRANCH", "ADMIN")
//		        .antMatchers("/user/get/client").hasAnyRole("BRANCH", "ADMIN")
//		        .antMatchers("/user/edit/client").hasAnyRole("BRANCH", "ADMIN")
//		        .antMatchers("/user/delete/client").hasAnyRole("BRANCH", "ADMIN")
		        
		        /***********Usuario marketing *************************************/
//		        .antMatchers("/statistics**").hasAnyRole("MARKETING","ADMIN")
//		        .antMatchers("/promos**","/promos/**").hasAnyRole("MARKETING","ADMIN")
//		        .antMatchers("/blog**","/blog/**").hasAnyRole("MARKETING","ADMIN")
//		        .antMatchers("/push**","/push/**").hasAnyRole("MARKETING","ADMIN")
//		        .antMatchers("/surveys**","/surveys/**").hasAnyRole("MARKETING","ADMIN")
//		        
		        /***********El resto solo usuario admin ****************************/
//                .anyRequest().hasRole("ADMIN");
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/css/**")
                .antMatchers("/js/**");
    }
	
	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
		tilesViewResolver.setViewClass(TilesView.class);
		return tilesViewResolver;
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tiles = new TilesConfigurer();
		tiles.setDefinitions("/WEB-INF/tiles.xml");
		return tiles;
	}
}
