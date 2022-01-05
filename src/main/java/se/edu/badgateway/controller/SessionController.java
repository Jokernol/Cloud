package se.edu.badgateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.edu.badgateway.pojo.DTO.LoginUser;
import se.edu.badgateway.service.PlaceService;
import se.edu.badgateway.service.UserService;

import javax.servlet.http.HttpSession;

@Controller()
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private UserService userService;

    @Autowired
    private PlaceService placeService;

    @GetMapping("/login")
    public String toLogin(){
        return "sessions/login";
    }

    @PostMapping(value = "/login")
    public ModelAndView userLogin(RedirectAttributes attributes,LoginUser loginUser, ModelAndView modelAndView, HttpSession session){
        Integer result=userService.userLogin(loginUser,session);

        if (result != -1){
            attributes.addFlashAttribute("msg","success");
            attributes.addFlashAttribute("info","登录成功");
            modelAndView.setViewName("redirect:/user/index");
        }else{
            attributes.addFlashAttribute("msg","danger");
            attributes.addFlashAttribute("info","登录失败");
            modelAndView.setViewName("redirect:/session/login");

        }
        return modelAndView;

    }

}
