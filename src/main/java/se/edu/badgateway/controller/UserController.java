package se.edu.badgateway.controller;


import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.edu.badgateway.pojo.DTO.IndexHighRiskPeople;
import se.edu.badgateway.pojo.DTO.RegistUser;
import se.edu.badgateway.pojo.DTO.RiskDataDTO;
import se.edu.badgateway.pojo.DTO.RiskPlaceDTO;
import se.edu.badgateway.service.PlaceService;
import se.edu.badgateway.service.RiskDataService;
import se.edu.badgateway.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller()
@RequestMapping("/user")
public class UserController {


    @Autowired
    private  UserService userService;

    @Autowired
    private PlaceService placeService;

    @Autowired
    private RiskDataService riskDataService;


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


    @PostMapping("uploadRiskData")
    public ModelAndView uploadRiskData(ModelAndView modelAndView,RiskDataDTO riskDataDTO){
        riskDataService.declareRiskData(riskDataDTO);
        modelAndView.setViewName("userHome");
        return modelAndView;
    }





    @GetMapping("getAllHighRiskPeople")
    public ModelAndView getAllHighRiskPeople(ModelAndView modelAndView){
        List<IndexHighRiskPeople> indexHighRiskPeople= userService.getAllHighRiskPeople();
        modelAndView.addObject("indexHighRiskPeople",indexHighRiskPeople);
        modelAndView.setViewName("allHighRiskPeople");
        return modelAndView;

    }






    @RequestMapping("auditDeclaration")
    public ModelAndView auditDeclaration(ModelAndView modelAndView, @Param("userId") String userId,@Param("riskRating") String riskRating){
        userService.auditDeclaration(userId,riskRating);
        List<RiskDataDTO> riskDataDTOs= userService.getAllRiskDataDto();
        modelAndView.addObject("riskDataDTOs",riskDataDTOs);
        modelAndView.setViewName("allRiskDataDTOs");
        return modelAndView;
    }




    @PostMapping("addRiskPlace")
    public ModelAndView addRiskPlace(ModelAndView modelAndView, RiskPlaceDTO riskPlaceDTO, @Param("intro") String intro){
        placeService.addRiskPlace(riskPlaceDTO,intro);
        List<RiskPlaceDTO> riskPlaceDTOS =placeService.getIndexRiskPlace();
        modelAndView.addObject("riskPlaceDTOS",riskPlaceDTOS);
        modelAndView.setViewName("adminHome");
        return modelAndView;

    }


    @DeleteMapping("deleteRiskPlace")
    public ModelAndView deleteRiskPlace(ModelAndView modelAndView,RiskPlaceDTO riskPlaceDTO){
        placeService.deleteRiskPlace(riskPlaceDTO);
        List<RiskPlaceDTO> riskPlaceDTOS =placeService.getIndexRiskPlace();
        modelAndView.addObject("riskPlaceDTOS",riskPlaceDTOS);
        modelAndView.setViewName("adminHome");
        return modelAndView;
    }




    @GetMapping("getAllRiskData")
    public ModelAndView getAllRiskData(ModelAndView modelAndView){
        List<RiskDataDTO> riskDataDTOs= userService.getAllRiskDataDto();
        modelAndView.addObject("riskDataDTOs",riskDataDTOs);
        modelAndView.setViewName("allRiskDataDTOs");
        return modelAndView;

    }


    @GetMapping("/index")
    public ModelAndView toIndex(ModelAndView modelAndView){
        modelAndView.setViewName("users/index");
        return modelAndView;
    }


}
