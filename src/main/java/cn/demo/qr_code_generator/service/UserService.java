package cn.demo.qr_code_generator.service;

import cn.demo.qr_code_generator.bean.User;
import cn.demo.qr_code_generator.dao.UserDAO;
import cn.demo.qr_code_generator.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserDAO userDAO;

    public User getUser()
    {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDAO.findById(userDetails.getUsername()).get();
    }

    public void register(User user)
    {
        user.setPassword(MD5Util.encode(user.getPassword()));
        userDAO.save(user);
    }
}
