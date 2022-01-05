package se.edu.badgateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import se.edu.badgateway.pojo.DTO.RiskDataDTO;
import se.edu.badgateway.service.RiskDataService;

import javax.annotation.Resource;

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
}
