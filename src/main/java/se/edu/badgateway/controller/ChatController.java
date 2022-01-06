package se.edu.badgateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.edu.badgateway.mapper.ChatMapper;
import se.edu.badgateway.mapper.UserMapper;
import se.edu.badgateway.pojo.DO.Chat;
import se.edu.badgateway.pojo.DO.User;
import se.edu.badgateway.service.ChatService;
import se.edu.badgateway.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("chat")
public class ChatController {

    @Autowired
    ChatService chatService;

    @Autowired
    ChatMapper chatMapper;

    @Autowired
    UserMapper userMapper;
    @RequestMapping("chat/{id}")
    public ModelAndView toChat(@PathVariable("id") int id, HttpSession session, ModelAndView modelAndView){
        User user = (User)session.getAttribute("user");

        if (user == null){
            modelAndView.setViewName("redirect:/user/index");
            return modelAndView;
        }

        User user1 = userMapper.selectById(id);

        List<Chat> chatList =  chatService.getChatRecords(user.getId(),id);

        System.out.println(chatList);
        modelAndView.addObject("chatList",chatList);

        modelAndView.setViewName("chat/chats");

        modelAndView.addObject("receiver",user1);

        return modelAndView;
    }

    @PostMapping("/form/{receiverId}")
    public ModelAndView chatForm(RedirectAttributes attributes, @PathVariable("receiverId")int id, ModelAndView modelAndView, HttpSession session, Chat chat){
        User user =(User)session.getAttribute("user");
        if (user == null){
            modelAndView.setViewName("redirect:/user/index");
            return modelAndView;
        }

        chat.setSenderId(user.getId());
        chat.setReceiverId(id);

        chatService.addChat(chat);
        attributes.addFlashAttribute("msg","success");
        attributes.addFlashAttribute("info","发送成功");

        modelAndView.setViewName("redirect:/chat/chat/"+id);

        return modelAndView;
    }


}
