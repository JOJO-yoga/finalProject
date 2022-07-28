package com.example.finalproject.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class loginConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    /**
     * @param
     * @method 密码加密规则
     */
    @Bean
    PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }

    /**
     * @param
     * @method 配置过滤规则 url层面
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //退出
        http.logout().logoutUrl("/logout").
                logoutSuccessUrl("/login").permitAll();

        //配置没有权限访问跳转自定义页面
        http.exceptionHandling().accessDeniedPage("/unauth.html");
        http.authorizeRequests()
                .antMatchers("/", "/login").permitAll() //设置哪些路径可以直接访问，不需要认证
                .anyRequest().permitAll();
        //配置 登录的相关
        http.formLogin()   //自定义自己编写的登录页面
                .loginPage("/login")  //登录页面设置
                .loginProcessingUrl("/user/dologin").permitAll()  //登录访问路径
                .usernameParameter("Id")
                .passwordParameter("password")
                .defaultSuccessUrl("/index").permitAll()  //登录成功之后，跳转路径
                .failureUrl("/login");

        //关闭csrf防护
        http.csrf().disable();
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/static/css/**")
                .antMatchers("/static/images/**")
                .antMatchers("/static/**");
    }
}
