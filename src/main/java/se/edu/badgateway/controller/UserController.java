package se.edu.badgateway.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.SneakyThrows;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.edu.badgateway.mapper.UserMapper;
import se.edu.badgateway.pojo.DO.User;
import se.edu.badgateway.pojo.DTO.IndexHighRiskPeople;
import se.edu.badgateway.pojo.DTO.RegistUser;
import se.edu.badgateway.pojo.DTO.RiskDataDTO;
import se.edu.badgateway.pojo.DTO.RiskPlaceDTO;
import se.edu.badgateway.service.InfoService;
import se.edu.badgateway.service.PlaceService;
import se.edu.badgateway.service.RiskDataService;
import se.edu.badgateway.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Controller()
@RequestMapping("/user")
public class UserController {


    @Resource
    InfoService infoService;

    @Autowired
    private UserMapper userMapper;

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
    public ModelAndView auditDeclaration(ModelAndView modelAndView, @Param("userId") String userId,@Param("riskRating") String riskRating){
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

    @GetMapping("/changeAvatar")
    public ModelAndView toChangeAvatar(ModelAndView modelAndView){
        modelAndView.setViewName("/users/changeAvatar");
        return modelAndView;
    }

    @SneakyThrows
    @PostMapping("/changeAvatar")
    public ModelAndView changeAvatar(@RequestParam("file")MultipartFile file, HttpServletRequest req,
                                     HttpSession session,ModelAndView modelAndView,RedirectAttributes attributes){
        User u =(User)session.getAttribute("user");
        if (u ==null){
            modelAndView.setViewName("redirect:/user/index");
            return modelAndView;
        }

        if (file ==null){
            attributes.addFlashAttribute("msg","warning");
            attributes.addFlashAttribute("info","请选择文件");
            modelAndView.addObject("redirect:/user/changeAvatar");
        }
        String path = req.getServletContext().getRealPath("/public/static/Avatar/");

        String filename = file.getOriginalFilename();
        // 获取原文件名
        String fileName = u.getId()+ Objects.requireNonNull(filename).substring(filename.lastIndexOf("."));
        // 创建文件实例
        File filePath = new File(path, fileName);
        // 如果文件目录不存在，创建目录
        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
        }
        // 写入文件
        file.transferTo(filePath);

        attributes.addFlashAttribute("msg","success");
        attributes.addFlashAttribute("info","上传成功");

        modelAndView.setViewName("redirect:/user/index");
        return modelAndView;
    }

    @GetMapping("/userList")
    public ModelAndView userList(ModelAndView modelAndView){
        List<User> users = userMapper.selectList(null);
        modelAndView.addObject("userList",users);
        modelAndView.setViewName("users/userList");
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView searchUser(ModelAndView modelAndView,@RequestParam("search") String search){
        List<User> users = userMapper.selectList(new QueryWrapper<User>()
                .like("name",search));
        modelAndView.addObject("userList",users);
        modelAndView.setViewName("users/userList");
        return modelAndView;
    }


}
