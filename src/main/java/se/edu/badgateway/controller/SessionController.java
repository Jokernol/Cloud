package se.edu.badgateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import se.edu.badgateway.dto.IndexRiskPlace;
import se.edu.badgateway.dto.LoginUser;
import se.edu.badgateway.service.PlaceService;
import se.edu.badgateway.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.List;

@Controller()
@RequestMapping("/session")
public class SessionController {


    @Autowired
    UserService userService;

    @Autowired
    PlaceService placeService;

    @PostMapping(value = "/login")
    public ModelAndView userLogin(LoginUser loginUser, ModelAndView modelAndView,HttpServletRequest req,HttpSession session){
        Integer result=userService.userLogin(loginUser);
        List<IndexRiskPlace> indexRiskPlaces=placeService.getIndexRiskPlace();
        switch (result) {
            case 0:
                session.setAttribute("loginUser", loginUser);
                modelAndView.addObject("indexRiskPlaces", indexRiskPlaces);
                modelAndView.setViewName("adminHome");
                return modelAndView;

            case 1:
                session.setAttribute("loginUser", loginUser);
                modelAndView.addObject("indexRiskPlaces", indexRiskPlaces);
                modelAndView.setViewName("userHome");
                return modelAndView;

            default:
                String info = "error";
                modelAndView.addObject("info",info);
                modelAndView.setViewName("login");
                return modelAndView;

        }

    }

}
