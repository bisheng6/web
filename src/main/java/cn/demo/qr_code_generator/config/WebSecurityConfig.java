package cn.demo.qr_code_generator.config;

import cn.demo.qr_code_generator.service.CustomUserService;
import cn.demo.qr_code_generator.util.MD5Util;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
//                .antMatchers("**").permitAll()
                .antMatchers("/login/**", "/register/**", "/register.html").permitAll()
//                .antMatchers( "/mplayer.html", "/vplayer.html", "/file/**", "/video/**", "/music/**").permitAll()
                .antMatchers("/businesscard", "/card", "/card/**").permitAll()
                .antMatchers(HttpMethod.GET, "/businessCard").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/upload/**").permitAll()
                .antMatchers("/player", "/video/**", "/music/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/login")
                .successForwardUrl("/main")
                .failureUrl("/login?error").permitAll()
                .and()
                .csrf().disable();
    }
}
