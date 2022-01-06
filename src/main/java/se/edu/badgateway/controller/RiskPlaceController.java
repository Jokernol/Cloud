package se.edu.badgateway.controller;


import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.edu.badgateway.mapper.RiskPlaceMapper;
import se.edu.badgateway.pojo.DO.RiskPlace;
import se.edu.badgateway.pojo.DTO.RiskPlaceDTO;
import se.edu.badgateway.service.PlaceService;

import java.util.List;

@Controller
@RequestMapping("/riskPlace")
public class RiskPlaceController {


    @Autowired
    private RiskPlaceMapper riskPlaceMapper;

    @Autowired
    private PlaceService placeService;

    @GetMapping("allAddress")
    public ModelAndView allAddress(ModelAndView modelAndView){
        modelAndView.addObject("riskList",placeService.getIndexRiskPlace());
        modelAndView.setViewName("address/adress");
        return modelAndView;
    }

    @GetMapping("/addRiskPlace")
    public ModelAndView toAddRiskPlace(ModelAndView modelAndView){
        modelAndView.setViewName("address/addAddress");
        return modelAndView;
    }

    @GetMapping("/deleteRiskPlace")
    public ModelAndView toDeleteRiskPlace(ModelAndView modelAndView){
        modelAndView.addObject("riskList",placeService.getIndexRiskPlace());
        modelAndView.setViewName("address/deleteAddress");
        return modelAndView;
    }

    @PostMapping("addRiskPlace")
    public ModelAndView addRiskPlace(ModelAndView modelAndView, RiskPlace riskPlace,RedirectAttributes attributes){
        placeService.addRiskPlace(riskPlace);
        modelAndView.setViewName("redirect:/riskPlace/allAddress");
        return modelAndView;

    }



    @GetMapping("deleteRiskPlace/{id}")
    public ModelAndView deleteRiskPlace(RedirectAttributes attributes,ModelAndView modelAndView, @PathVariable("id")int id){
        riskPlaceMapper.deleteById(id);
        attributes.addFlashAttribute("msg","success");
        attributes.addFlashAttribute("info","删除成功");
        modelAndView.setViewName("redirect:/riskPlace/allAddress");
        return modelAndView;
    }


}
