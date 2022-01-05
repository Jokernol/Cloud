package se.edu.badgateway.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import se.edu.badgateway.pojo.DTO.IndexHighRiskPeople;
import se.edu.badgateway.pojo.DTO.RegistUser;
import se.edu.badgateway.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller()
@RequestMapping("/User")
public class UserController {


    @Autowired
    private  UserService userService;


    @PostMapping("regist")
    public ModelAndView userRegist(RegistUser registUser,ModelAndView modelAndView, HttpSession session){
        userService.userRegist(registUser);
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @GetMapping("getAllHighRiskPeople")
    public ModelAndView getAllHighRiskPeople(ModelAndView modelAndView){
        List<IndexHighRiskPeople> indexHighRiskPeople= userService.getAllHighRiskPeople();
        modelAndView.addObject("indexHighRiskPeople",indexHighRiskPeople);
        modelAndView.setViewName("AllHighRiskPeople");
        return modelAndView;

    }



}
