package cn.demo.qr_code_generator.controller;

import cn.demo.qr_code_generator.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController
{
    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(Model model, @RequestParam("type") Integer type, @RequestParam("file") MultipartFile file)
    {
        String url =  fileService.upload(type, file);
        model.addAttribute("type", type);
        model.addAttribute("url", url);
        return "main";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload(Model model, int type)
    {
        model.addAttribute("type", type);
        return "upload";
    }

    @RequestMapping(value = "/player", method = RequestMethod.GET)
    public String play(Model model, int type, String path)
    {
        model.addAttribute("path", path);
        switch (type)
        {
            case 2:
                return "mplayer";
            case 3:
                return "vplayer";
        }
        return null;
    }
}
