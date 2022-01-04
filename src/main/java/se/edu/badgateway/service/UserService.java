package se.edu.badgateway.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.edu.badgateway.dto.IndexRiskPlace;
import se.edu.badgateway.dto.LoginUser;
import se.edu.badgateway.mapper.RiskPlaceMapper;
import se.edu.badgateway.mapper.UserMapper;
import se.edu.badgateway.pojo.RiskPlace;
import se.edu.badgateway.pojo.User;

import java.util.ArrayList;
import java.util.List;


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
