package se.edu.badgateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import se.edu.badgateway.mapper.UserMapper;
import se.edu.badgateway.pojo.DO.RiskData;
import se.edu.badgateway.pojo.DO.User;
import se.edu.badgateway.pojo.DTO.RiskDataDTO;
import se.edu.badgateway.service.RiskDataService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Action;
import java.util.Map;

@Controller
@RequestMapping("/riskData")
public class RiskDataController {
    @Resource
    RiskDataService riskDataService;

    @Autowired
    UserMapper userMapper;
    //申请重新评估风险等级
    @GetMapping("evaluate")
    public ModelAndView evaluate(ModelAndView modelAndView){
        modelAndView.setViewName("RiskData/evaluate");
        return modelAndView;
    }

    @GetMapping("riskList")
    public ModelAndView riskList(ModelAndView modelAndView){
        modelAndView.setViewName("RiskData/RiskList");
        Map<User, RiskData> map =  riskDataService.getAllRiskDataDto();
        modelAndView.addObject("riskList",map);
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addRiskData(ModelAndView modelAndView,HttpSession session, RiskDataDTO riskDataDTO) {
        User user =(User)session.getAttribute("user");
        if (user ==null){
            modelAndView.setViewName("redirect:/user/index");
            return modelAndView;
        }
        user.setHealthCodeType(0);
        userMapper.updateById(user);
        riskDataDTO.setUserId(user.getId());
        riskDataService.declareRiskData(riskDataDTO);
        return new ModelAndView("redirect:/user/index");
    }

    @GetMapping("getAllRiskData")
    public ModelAndView getAllRiskData(ModelAndView modelAndView){
        modelAndView.addObject("map",riskDataService.getAllRiskDataDto());
        modelAndView.setViewName("allRiskDataDTOs");
        return modelAndView;
    }
}
