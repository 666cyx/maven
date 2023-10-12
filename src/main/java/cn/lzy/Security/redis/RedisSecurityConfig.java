package cn.lzy.Security.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author 陈远翔
 * @date 2023/10/10 10:52
 */
@EnableWebSecurity
public class RedisSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
    }
   @Override
   protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests()
               .antMatchers("/").permitAll()
               .antMatchers("/login/**").permitAll()
               .antMatchers("/detail/common/**").hasRole("common")
               .antMatchers("/detail/vip/**").hasRole("vip")
               .anyRequest().authenticated()
               .and()
               .formLogin();
       http.formLogin()
               .loginPage("/userLogin").permitAll()
               .usernameParameter("name").passwordParameter("pwd")
               .defaultSuccessUrl("/")
               .failureUrl("/userLogin?error");

       http.logout()
               .logoutUrl("/mylogout")
               .logoutSuccessUrl("/");

   }

}

