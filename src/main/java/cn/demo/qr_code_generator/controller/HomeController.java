package cn.demo.qr_code_generator.controller;

import cn.demo.qr_code_generator.bean.User;
import cn.demo.qr_code_generator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController
{
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/login"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String login()
    {
        if (!SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser"))
            return "main";
        return "login";
    }

    @RequestMapping(value = "/main", method = {RequestMethod.GET, RequestMethod.POST})
    public String home(Model model)
    {
        model.addAttribute("url", "https://github.com/bisheng6/web");
        return "main";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(User user)
    {
        userService.register(user);
        return "login";
    }
}
