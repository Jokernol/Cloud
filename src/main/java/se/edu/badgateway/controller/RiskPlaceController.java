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
import se.edu.badgateway.pojo.DTO.RiskPlaceDTO;
import se.edu.badgateway.service.PlaceService;

import java.util.List;

@Controller
@RequestMapping("/riskPlace")
public class RiskPlaceController {


    @Autowired
    private PlaceService placeService;





    @GetMapping("adminHome")
    public String toAdminHome(RedirectAttributes attr){
        List<RiskPlaceDTO> riskPlaceDTOS =placeService.getIndexRiskPlace();
        attr.addFlashAttribute("riskPlaceDTOS",riskPlaceDTOS);
        return "users/adminHome" ;
    }

    @PostMapping("addRiskPlace")
    public ModelAndView addRiskPlace(ModelAndView modelAndView, RiskPlaceDTO riskPlaceDTO){
        placeService.addRiskPlace(riskPlaceDTO);
        modelAndView.setViewName("redirect:/user/index");
        return modelAndView;

    }


    @DeleteMapping("deleteRiskPlace")
    public ModelAndView deleteRiskPlace(ModelAndView modelAndView,RiskPlaceDTO riskPlaceDTO){
        placeService.deleteRiskPlace(riskPlaceDTO);
        modelAndView.setViewName("redirect:/riskPlace/adminHome");
        return modelAndView;
    }


}
