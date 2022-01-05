package se.edu.badgateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import se.edu.badgateway.pojo.DTO.RiskDataDTO;
import se.edu.badgateway.service.RiskDataService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/riskData")
public class RiskDataController {
    @Resource
    RiskDataService riskDataService;

    @GetMapping("/add")
    public ModelAndView toRiskData() {
        return new ModelAndView("redirect:riskData");
    }

    @PostMapping("/add/{userId}")
    public ModelAndView addRiskData(RiskDataDTO riskDataDTO) {
        riskDataService.declareRiskData(riskDataDTO);
        return new ModelAndView("redirect:userHome");
    }

    @GetMapping("getAllRiskData")
    public ModelAndView getAllRiskData(ModelAndView modelAndView){
        List<RiskDataDTO> riskDataDTOs = new LinkedList<RiskDataDTO>();
        riskDataDTOs = riskDataService.getAllRiskDataDto();
        modelAndView.addObject("riskDataDTOs",riskDataDTOs);
        modelAndView.setViewName("allRiskDataDTOs");
        return modelAndView;

    }
}
