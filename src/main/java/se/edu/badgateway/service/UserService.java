package se.edu.badgateway.service;

import com.baomidou.mybatisplus.core.toolkit.BeanUtils;
import net.sf.cglib.beans.BeanCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.edu.badgateway.mapper.UserMapper;
import se.edu.badgateway.pojo.DO.User;
import se.edu.badgateway.pojo.DTO.IndexHighRiskPeople;
import se.edu.badgateway.pojo.DTO.LoginUser;
import se.edu.badgateway.pojo.DTO.RegistUser;


import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Component
public class UserService {


    @Autowired
    UserMapper userMapper;


    public boolean userRegist(RegistUser registUser){
        final BeanCopier beanCopier = BeanCopier.create(RegistUser.class,User.class, false);
        User user=new User();
        beanCopier.copy(registUser,user,null);
        userMapper.insert(user);
        return true;
    }

    public List<IndexHighRiskPeople> getAllHighRiskPeople(){
        List<IndexHighRiskPeople> indexHighRiskPeople=userMapper.getHighRiskPeople();
        return indexHighRiskPeople;
    }




    public Integer userLogin(LoginUser loginUser, HttpSession session) {
        Map<String, Object> map = BeanUtils.beanToMap(loginUser);
        List<User> users = userMapper.selectByMap(map);

        if (users == null) {
            return -1;
        }

        session.setAttribute("user",users.get(0));
        if(users.get(0).getType()==0){
            return 0;
        }else {
            return 1;
        }



    }
}

