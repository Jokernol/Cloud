package se.edu.badgateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.edu.badgateway.pojo.DTO.InfoDTO;
import se.edu.badgateway.service.InfoService;

import javax.annotation.Resource;

@Controller
@RequestMapping("/Info")
public class InfoController {
    @Resource
    InfoService infoService;


    @PostMapping("/add")
    public ModelAndView addInfo(InfoDTO infoDTO, RedirectAttributes attributes) {
        infoService.addInfo(infoDTO);
        attributes.addFlashAttribute("msg","success");
        attributes.addFlashAttribute("info","添加成功");

        return new ModelAndView("redirect:/user/index");
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteInfo(@PathVariable Integer id,RedirectAttributes attributes) {
        infoService.deleteInfo(id);
        attributes.addFlashAttribute("msg","success");
        attributes.addFlashAttribute("info","添加成功");
        return new ModelAndView("redirect:/user/index");
    }

}
