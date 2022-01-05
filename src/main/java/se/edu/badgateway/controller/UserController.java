package se.edu.badgateway.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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


    @GetMapping("regist")
    public String toRegist(){
        return "users/create";
    }

    @PostMapping("/regist")
    public ModelAndView userRegist(RedirectAttributes attr, RegistUser registUser, ModelAndView modelAndView, HttpSession session){
        userService.userRegist(registUser);
        attr.addFlashAttribute("msg","success");
        attr.addFlashAttribute("info","注册成功");
        modelAndView.setViewName("redirect:/session/login");
        return modelAndView;
    }

    @GetMapping("getAllHighRiskPeople")
    public ModelAndView getAllHighRiskPeople(ModelAndView modelAndView){
        List<IndexHighRiskPeople> indexHighRiskPeople= userService.getAllHighRiskPeople();
        modelAndView.addObject("indexHighRiskPeople",indexHighRiskPeople);
        modelAndView.setViewName("AllHighRiskPeople");
        return modelAndView;

    }


    @GetMapping("/index")
    public ModelAndView toIndex(ModelAndView modelAndView){
        modelAndView.setViewName("users/index");
        return modelAndView;
    }


}
