package com.BfDmichal.tradingplatform.security;

import com.BfDmichal.tradingplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/v1/user/createUser").permitAll()
                .antMatchers("/v1/user/deleteUser").hasRole("ADMIN")
                .antMatchers("/v1/user/updateUser").authenticated()
                .antMatchers("/v1/user/getUserAdvertisements").authenticated()
                .antMatchers("/v1/user/getUsers").hasRole("ADMIN")
                .antMatchers("/v1/user/getUser").authenticated()
                .antMatchers("/v1/getAdvertisements").permitAll()
                .antMatchers("/v1/getAdvertisement").permitAll()
                .antMatchers("/v1/deleteAdvertisement").authenticated()
                .antMatchers("/v1/updateAdvertisement").authenticated()
                .antMatchers("/v1/createAdvertisement").authenticated()
                .antMatchers("/v1/getCategories").permitAll()
                .antMatchers("/v1/getCategory").permitAll()
                .antMatchers("/v1/getAllSubcategories").permitAll()
                .antMatchers("/v1/updateCategory").authenticated()
                .antMatchers("/v1/deleteCategory").hasRole("ADMIN")
                .antMatchers("/v1/createCategory").hasRole("ADMIN")
                .antMatchers("/v1/getSubcategory").permitAll()
                .antMatchers("/v1/getSubcategories").authenticated()
                .antMatchers("/v1/deleteSubcategory").hasRole("ADMIN")
                .antMatchers("/v1/createSubcategory").hasRole("ADMIN")
                .antMatchers("/v1/updateSubcategory").hasRole("ADMIN")
                .and()
                .formLogin().permitAll();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
