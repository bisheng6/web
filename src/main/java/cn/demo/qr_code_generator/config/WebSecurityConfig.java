package cn.demo.qr_code_generator.config;

import cn.demo.qr_code_generator.service.CustomUserService;
import cn.demo.qr_code_generator.util.MD5Util;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Bean
    UserDetailsService customUserService()
    {
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(customUserService()).passwordEncoder(new PasswordEncoder()
        {
            @Override
            public String encode(CharSequence charSequence)
            {
                return MD5Util.encode((String) charSequence);
            }

            @Override
            public boolean matches(CharSequence charSequence, String s)
            {
                return s.equals(MD5Util.encode((String) charSequence));
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers("/index").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .usernameParameter("Username")
                .passwordParameter("Password")
                .loginPage("/index")
                .defaultSuccessUrl("/main")
                .failureUrl("/index?error").permitAll()
                .and()
                .csrf().disable();
    }
}