///*
//     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.lnht.configs;
//
//import com.lnht.components.JwtService;
//import com.lnht.filters.CustomAccessDeniedHandler;
//import com.lnht.filters.JwtAuthenticationTokenFilter;
//import com.lnht.filters.RestAuthenticationEntryPoint;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
///**
// *
// * @author minh-nguyen
// */
//@Configuration
//@EnableWebSecurity
//@EnableTransactionManagement
//@ComponentScan(basePackages = {
//    "com.lnht.controllers",
//    "com.lnht.repository",
//    "com.lnht.service",
//    "com.lnht.components",
//    "com.lnht.validator"
//})
//@Order(1)
//public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Bean
//    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() throws Exception {
//        JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter = new JwtAuthenticationTokenFilter();
//        jwtAuthenticationTokenFilter.setAuthenticationManager(authenticationManager());
//        return jwtAuthenticationTokenFilter;
//    }
//
//    @Bean
//    public RestAuthenticationEntryPoint restServicesEntryPoint() {
//        return new RestAuthenticationEntryPoint();
//    }
//
//    @Bean
//    public CustomAccessDeniedHandler customAccessDeniedHandler() {
//        return new CustomAccessDeniedHandler();
//    }
//
//    @Bean
//    @Override
//    protected AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http.csrf().disable();
////
////       http.formLogin().loginPage("/")
////                .usernameParameter("username")
////                .passwordParameter("password");
////        http.formLogin().defaultSuccessUrl("/").failureUrl("/?error");
////        http.logout().logoutSuccessUrl("/");
////        
////        http.authorizeRequests().antMatchers("/", "/register", "/login").permitAll();
////        
////        http.antMatcher("/**").httpBasic().authenticationEntryPoint(restServicesEntryPoint())
////                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////                .and().authorizeRequests().antMatchers("/user/", "/images/", "/faculty/", "faculty/**", "/admission-news/", "/comments/", "/questions/")
////                .hasRole("instructor")
////                
////                .and().exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
//
////        http.authorizeRequests()
////                .antMatchers(HttpMethod.GET,  "/register").denyAll()
////                .and().authorizeRequests().antMatchers(HttpMethod.POST, "/register").denyAll();
////        http.authorizeRequests()
////                .antMatchers("/register", "/user/**", "/images/**", "/faculty/**", "/admission-news/**", "/comments/**", "/questions/**")
////                .authenticated().and()
////                .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
////        http.authorizeRequests()
////                .antMatchers("/user/", "/images/", "/faculty/", "faculty/**", "/admission-news/", "/comments/", "/questions/")
////                .denyAll();
//
////        http.authorizeRequests()
////                .antMatchers("/user/{id:[0-9]+}", "/images/{id:[0-9]+}-{type:[a-zA-Z]+}", "/faculty/{id:[0-9]+}", "faculty/**/{id:[0-9]+}", "/admission-news/{id:[0-9]+}", "/comments/{id:[0-9]+}", "/questions/{id:[0-9]+}")
////                .hasRole("instructor");
////
////        http.authorizeRequests()
////                .antMatchers("/user/**", "/images/**", "/faculty/**", "/admission-news/**", "/comments/**", "/questions/**")
////                .access("hasRole('admin')").and().httpBasic().authenticationEntryPoint(restServicesEntryPoint())
////                .and()
////                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
////                .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
////                .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
////        http.antMatcher("/**").httpBasic().authenticationEntryPoint(restServicesEntryPoint()).and()
////        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
////        http.authorizeRequests().anyRequest().authenticated();
////        http.antMatcher("/**").httpBasic().authenticationEntryPoint(restServicesEntryPoint()).and()
////                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
////                .authorizeRequests()
////                .antMatchers(HttpMethod.GET, "/**").access("hasRole('admin') or hasRole('instructor')")
////                .antMatchers(HttpMethod.POST, "/**").access("hasRole('admin')")
////                .antMatchers(HttpMethod.DELETE, "/**").access("hasRole('admin')").and()
////                .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
////                .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
//    }
//}
