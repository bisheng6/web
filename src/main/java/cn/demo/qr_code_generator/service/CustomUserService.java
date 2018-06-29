package cn.demo.qr_code_generator.service;

import cn.demo.qr_code_generator.bean.User;
import cn.demo.qr_code_generator.dao.UserDAO;
import cn.demo.qr_code_generator.bean.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserService implements UserDetailsService
{
    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {
        User user = userDAO.getOne(s);
        return new SecurityUser(user.getUsername(), user.getPassword(), null);
    }
}
