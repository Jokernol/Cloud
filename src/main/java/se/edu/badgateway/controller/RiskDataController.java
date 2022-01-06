package se.edu.badgateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import se.edu.badgateway.pojo.DO.RiskData;
import se.edu.badgateway.pojo.DTO.RiskDataDTO;
import se.edu.badgateway.pojo.DTO.UserDTO;
import se.edu.badgateway.service.RiskDataService;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/riskData")
public class RiskDataController {
    @Resource
    RiskDataService riskDataService;


    //申请重新评估风险等级
    @GetMapping("evaluate")
    public ModelAndView evaluate(ModelAndView modelAndView){
        modelAndView.setViewName("RiskData/evaluate");
        return modelAndView;
    }

    @GetMapping("riskList")
    public ModelAndView riskList(ModelAndView modelAndView){
        modelAndView.setViewName("RiskData/RiskList");
        Map<UserDTO, RiskData> map =  riskDataService.getAllRiskDataDto();
        modelAndView.addObject("riskList",map);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView toRiskData() {
        return new ModelAndView("RiskData/appQRCode");
    }

    @PostMapping("/add/{userId}")
    public ModelAndView addRiskData(RiskDataDTO riskDataDTO) {
        riskDataService.declareRiskData(riskDataDTO);
        return new ModelAndView("redirect:userHome");
    }

    @GetMapping("getAllRiskData")
    public ModelAndView getAllRiskData(ModelAndView modelAndView){
        modelAndView.addObject("map",riskDataService.getAllRiskDataDto());
        modelAndView.setViewName("allRiskDataDTOs");
        return modelAndView;
    }
}
