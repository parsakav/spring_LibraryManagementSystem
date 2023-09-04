package com.example.librarymanagementsystem.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    public UserDetailsService userDetailsService;



    @Bean(name = "authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
      /*  auth.inMemoryAuthentication().withUser("p").password("p").roles("USER");
        auth.inMemoryAuthentication().withUser("parsa").password("p").roles("ADMIN"); */
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       /* http.sessionManagement()
                .sessionConcurrency(concurrencyControlConfigurer -> {
concurrencyControlConfigurer.maximumSessions(1).maxSessionsPreventsLogin(true);
                }); */

        http.csrf().disable().authorizeRequests().antMatchers("/images/**","/book/list","/h2-console","/error","/","/index","/home","/signup/**", "/signup" , "/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css").permitAll()
                .antMatchers("/**").authenticated()
                .and().formLogin().loginPage("/login")

                .usernameParameter("username").passwordParameter("password").successForwardUrl("/").permitAll()
                .and()
                .logout().invalidateHttpSession(true).clearAuthentication(true).permitAll()
                .deleteCookies("remember-me")
                .and()
                .sessionManagement()
                .sessionFixation().migrateSession()
                .maximumSessions(1)
                .expiredUrl("/");

    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}