package cn.demo.qr_code_generator.service;

import cn.demo.qr_code_generator.bean.User;
import cn.demo.qr_code_generator.dao.UserDAO;
import cn.demo.qr_code_generator.bean.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class CustomUserService implements UserDetailsService
{
    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {
        User user = userDAO.findById(s).get();
        if (user.getUsername() == null)
            throw new UsernameNotFoundException("用户名不存在");
        return new SecurityUser(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
