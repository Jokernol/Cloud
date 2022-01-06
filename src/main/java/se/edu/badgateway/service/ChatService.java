package se.edu.badgateway.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.stereotype.Component;
import se.edu.badgateway.mapper.ChatMapper;
import se.edu.badgateway.mapper.UserMapper;
import se.edu.badgateway.pojo.DO.Chat;
import javax.annotation.Resource;

import se.edu.badgateway.pojo.DO.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ChatService {


    @Resource
    private ChatMapper chatMapper;

    @Resource
    private UserMapper userMapper;

    //得到聊天记录
    public List<Chat> getChatRecords(int senderId,int receiverId){
        List<Chat> chats = chatMapper.selectList(new QueryWrapper<Chat>()
                                                    .eq("sender_id",senderId)
                                                    .eq("receiver_id",receiverId)
                        .or().eq("sender_id",receiverId).eq("receiver_id",senderId)
                                                    .orderByAsc("time") );
        return chats;
    }
    //未读消息数量
    public Integer getMsgNum(int receiverId){

        Integer num= Math.toIntExact(chatMapper.selectCount(new QueryWrapper<Chat>()
                                                                .eq("receiver_id",receiverId)
                                                                .eq("is_read",0)));
        return  num;
    }

    //管理员获得未读消息列表
    public List<User> getFollowUsers(){
        List<Chat> senderIds= (chatMapper.selectList(new QueryWrapper<Chat>()
                                                        .select("sender_id")
                                                        .eq("receiver_id",1)
                                                        .eq("is_read",0)
                                                        .groupBy("sender_id")));

        List<User> users=new ArrayList<>();
        for (Chat item:senderIds) {
            User user=(userMapper.selectOne(new QueryWrapper<User>()
                                                .eq("id",item.getSenderId())));
            users.add(user);
        }

        return users;
    }

    public void checkNews(int receiverId,int senderId){
        UpdateWrapper<Chat> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("receiver_Id",receiverId).eq("sender_id",senderId);
        Chat chat = new Chat();
        chat.setReceiverId(receiverId);
        chat.setSenderId(senderId);
        chat.setIsRead(1);
        chatMapper.update(chat, updateWrapper);


    }

    public void addChat(Chat chat){
        chat.setTime(LocalDateTime.now());
        chatMapper.insert(chat);
    }
}
