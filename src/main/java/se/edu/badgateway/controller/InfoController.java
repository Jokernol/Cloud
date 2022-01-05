package se.edu.badgateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import se.edu.badgateway.pojo.DTO.InfoDTO;
import se.edu.badgateway.service.InfoService;

import javax.annotation.Resource;

@Controller
@RequestMapping("/Info")
public class InfoController {
    @Resource
    InfoService infoService;

    @GetMapping("/add")
    public ModelAndView toAddInfo() {
        return new ModelAndView("redirect:info");
    }

    @PostMapping("/add")
    public ModelAndView addInfo(InfoDTO infoDTO) {
        return new ModelAndView();
    }
}
