package edu.sxu.decision_sys.config;

import edu.sxu.decision_sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author wzw
 * @version 1.0
 * @description security配置类
 * @date 2020/5/1 17:41
 */
@Configuration
//@EnableWebSecurity: 禁用Boot的默认Security配置，配合@Configuration启用自定义配置
// （需要扩展WebSecurityConfigurerAdapter）
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true): 启用Security注解，
// 例如最常用的@PreAuthorize
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        //密码加密方式
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        // Configure spring security's authenticationManager with custom
        // user details service
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/bootstrap/**","/css/**","/easyui/**","/images/**","/js/**","/plugins/**");
    }

    @Override
    //configure(HttpSecurity): Request层面的配置，对应XML Configuration中的<http>元素
    //定义URL路径应该受到保护，哪些不应该
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 验证策略策略链接
                .authorizeRequests()
                    // 例如以下代码指定了/和/login不需要任何认证就可以访问，其他的路径都必须通过身份验证。
                    .antMatchers("/", "/login/**").permitAll()
                .anyRequest().authenticated()
                .and()
                //通过formLogin()定义当需要用户登录时候，转到的登录页面。
                .formLogin()
                .loginPage("/login")
//                .loginProcessingUrl("/login/form")
                // 访问指定页面，用户未登入，跳转至登入页面，如果登入成功，跳转至用户访问指定页面，用户访问登入页面，默认的跳转页面
//                .defaultSuccessUrl("/index")
                .successForwardUrl("/index")
                .failureUrl("/login-error")
                .permitAll()
                .and()
                //注销
                .logout()
//                .logoutUrl("/logout")
                .permitAll();
        //关闭csrf 防止循环定向
        http.csrf().disable();
    }
}
