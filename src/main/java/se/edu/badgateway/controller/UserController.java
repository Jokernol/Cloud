package se.edu.badgateway.controller;


import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.edu.badgateway.pojo.DO.User;
import se.edu.badgateway.pojo.DTO.IndexHighRiskPeople;
import se.edu.badgateway.pojo.DTO.RegistUser;
import se.edu.badgateway.pojo.DTO.RiskDataDTO;
import se.edu.badgateway.service.InfoService;
import se.edu.badgateway.service.PlaceService;
import se.edu.badgateway.service.RiskDataService;
import se.edu.badgateway.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller()
@RequestMapping("/user")
public class UserController {


    @Resource
    InfoService infoService;

    @Autowired
    private  UserService userService;

    @Autowired
    private PlaceService placeService;

    @Autowired
    private RiskDataService riskDataService;

    @GetMapping("/test")
    public String tset(){
        return "address/test";
    }

    @GetMapping("test2")
    public String test2(){
        return "address/addAddress";
    }

    @GetMapping("regist")
    public String toRegist(){
        return "users/create";
    }




    @GetMapping("showGetAllHighRiskPeople")
    public String toGetAllHighRiskPeople(RedirectAttributes attr){
        List<IndexHighRiskPeople> indexHighRiskPeople= userService.getAllHighRiskPeople();
        attr.addFlashAttribute("indexHighRiskPeople",indexHighRiskPeople);
        return "admin/allHighRiskPeople";
    }




    @GetMapping("showAuditDeclaration")
    public String auditDeclaration(RedirectAttributes attr){
        List<RiskDataDTO> riskDataDTOs= riskDataService.getAllRiskDataDto();
        attr.addFlashAttribute("riskDataDTOs",riskDataDTOs);
        return "admin/auditDeclaration";
    }









    @PostMapping("/regist")
    public ModelAndView userRegist(RedirectAttributes attr, RegistUser registUser, ModelAndView modelAndView){
        userService.userRegist(registUser);
        attr.addFlashAttribute("msg","success");
        attr.addFlashAttribute("info","注册成功");
        attr.addFlashAttribute("u",registUser);
        modelAndView.setViewName("redirect:/session/login");
        return modelAndView;
    }


    @PostMapping("uploadRiskData")
    public ModelAndView uploadRiskData(ModelAndView modelAndView,RiskDataDTO riskDataDTO){
        riskDataService.declareRiskData(riskDataDTO);
        modelAndView.setViewName("userHome");
        return modelAndView;
    }





    @GetMapping("getAllHighRiskPeople")
    public ModelAndView getAllHighRiskPeople(ModelAndView modelAndView,RedirectAttributes attr){
        modelAndView.setViewName("redirect:/user/showGetAllHighRiskPeople");
        return modelAndView;

    }




    @RequestMapping("auditDeclaration")
    public ModelAndView auditDeclaration(ModelAndView modelAndView, @Param("userId") Integer userId,@Param("riskRating") Integer riskRating){
        userService.auditDeclaration(userId,riskRating);
        modelAndView.setViewName("redirect:/user/showAuditDeclaration");
        return modelAndView;
    }



    @GetMapping("/index")
    public ModelAndView toIndex(ModelAndView modelAndView,HttpSession session){

        User user = (User) session.getAttribute("user");
        if (user != null){

            modelAndView.addObject("infoList",infoService.getInfoList());
            if(user.getType() == 0 ){
                modelAndView.setViewName("users/admin");
            }else if(user.getType() == 1){
                modelAndView.setViewName("users/index");
            }
        }else   {
            modelAndView.addObject("msg","info");
            modelAndView.addObject("info","请先登录");
            modelAndView.setViewName("redirect:/session/login");
        }
        return modelAndView;
    }


}
