package com.hasindu.userdetailsmanagamentsystem.util.security;

import com.hasindu.userdetailsmanagamentsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Spring Security Configurations
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login-history/*").hasRole("Standard")
                .antMatchers("/user/user-management").hasRole("Standard")
                .antMatchers("/user/modify-user").hasRole("Standard")
                .antMatchers("/user/save-user").hasRole("Standard")
                .antMatchers("/user/delete-user").hasRole("Standard")

                .antMatchers("/user/sign-up").permitAll()
                .antMatchers("/").permitAll()
                .and().formLogin().loginPage("/user/login").usernameParameter("userName")
                .passwordParameter("password").defaultSuccessUrl("/user/user-management?response=success").and().logout().permitAll();

    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


}
