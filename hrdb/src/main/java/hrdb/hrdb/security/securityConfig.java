/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrdb.hrdb.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author gabri
 */
@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
public class securityConfig extends WebSecurityConfigurerAdapter {

    /*
    1.
    membuat koneksi antara spring security dengan database yang ada di application properties
     */
    @Autowired
    private DataSource dataSource;

    @Autowired
    CustomSuccessHandler customSuccessHandler;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImp();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager() throws Exception {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
        jdbcUserDetailsManager.setDataSource(dataSource);
        return jdbcUserDetailsManager;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .authorizeRequests()
                .antMatchers(
                        "/forgetPass",
                        "/reset**",
                        "/forgotPassword").permitAll()
                .antMatchers("/indexAdm*").access("hasRole('MANAGER')")
                .antMatchers("/index*").access("hasRole('EMPLOYEE')")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/loginPage").permitAll()
                .successHandler(customSuccessHandler)
                .usernameParameter("email")
                .passwordParameter("password")
                .failureUrl("/loginPage?error=true")
                .permitAll()
                .and().csrf()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/Access_Denied")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .addLogoutHandler(new Logout())
                .logoutSuccessUrl("/loginPage");
    }

}
