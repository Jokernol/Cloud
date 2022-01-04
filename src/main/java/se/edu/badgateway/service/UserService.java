package se.edu.badgateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.edu.badgateway.mapper.UserMapper;
import se.edu.badgateway.pojo.DO.User;
import se.edu.badgateway.pojo.DTO.LoginUser;


@Component
public class UserService {


    @Autowired
    UserMapper userMapper;





    public Integer userLogin(LoginUser loginUser){

        User user =userMapper.login(loginUser.getName(), loginUser.getPassword());
        if(user==null){
            return -1;
        }else if(user.getType()==0){
            return 0;
        }else {
            return 1;
        }

    }
}
