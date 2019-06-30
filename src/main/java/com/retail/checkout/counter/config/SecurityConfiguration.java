package com.retail.checkout.counter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * Customizes the HttpSecurity method to disable the csrf token.
     *
     * @param http HttpSecurity
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.cors().and().csrf().disable();
    }

    /**
     * Customizes WebSecurity to ignores the swagger urls and from the basic authentication.
     *
     * @param webSecurity WebSecurity
     */
    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity.ignoring()
                .antMatchers("/",
                        "/v2/api-docs/**",
                        "/configuration/ui/**",
                        "/swagger-resources/**",
                        "/swagger-ui.html",
                        "/webjars/**");
    }
}
