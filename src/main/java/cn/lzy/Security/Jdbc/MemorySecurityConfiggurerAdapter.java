/*
package cn.lzy.Security.Jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

*/
/**
 * @author 陈远翔
 * @date 2023/10/9 9:56
 *//*

@EnableWebSecurity
public class MemorySecurityConfiggurerAdapter extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String userSQL ="select username,password,valid from t_customer "+ "where username = ?";
        String authoritySQL="select c.username,a.authority from t_customer c, "+"t_authority 	a,t_customer_authority ca where "+"ca.customer_id=c.id and ca.authority_id=a.id and 	c.username =?";
        auth.jdbcAuthentication().passwordEncoder(encoder).dataSource(dataSource)
                .usersByUsernameQuery(userSQL).authoritiesByUsernameQuery(authoritySQL);
    }

}

*/
