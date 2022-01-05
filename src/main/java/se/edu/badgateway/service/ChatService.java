package se.edu.badgateway.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Component;
import se.edu.badgateway.mapper.ChatMapper;
import se.edu.badgateway.mapper.UserMapper;
import se.edu.badgateway.pojo.DO.Chat;
import javax.annotation.Resource;

import se.edu.badgateway.pojo.DO.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChatService {


    @Resource
    private ChatMapper chatMapper;

    @Resource
    private UserMapper userMapper;

    public List<Chat> getChetRecords(int senderId,int receiverId){
        List<Chat> chats = chatMapper.selectList(new QueryWrapper<Chat>()
                                                    .eq("sender_id",senderId)
                                                    .eq("receiver_id",receiverId)
                                                    .orderByDesc("time") );
        return chats;
    }

    public Integer getMsgNum(int receiverId){

        Integer num= Math.toIntExact(chatMapper.selectCount(new QueryWrapper<Chat>()
                                                                .eq("receiver_id",receiverId)
                                                                .eq("is_read",0)));
        return  num;
    }
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
}
