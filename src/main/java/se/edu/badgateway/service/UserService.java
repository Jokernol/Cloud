package se.edu.badgateway.service;

import com.baomidou.mybatisplus.core.toolkit.BeanUtils;
import net.sf.cglib.beans.BeanCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.edu.badgateway.mapper.RiskDataMapper;
import se.edu.badgateway.mapper.UserMapper;
import se.edu.badgateway.pojo.DO.RiskData;
import se.edu.badgateway.pojo.DO.User;
import se.edu.badgateway.pojo.DTO.IndexHighRiskPeople;
import se.edu.badgateway.pojo.DTO.LoginUser;
import se.edu.badgateway.pojo.DTO.RegistUser;
import se.edu.badgateway.pojo.DTO.RiskDataDTO;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component
public class UserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RiskDataMapper riskDataMapper;


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

    public List<RiskDataDTO> getAllRiskDataDto(){
        final BeanCopier beanCopier = BeanCopier.create(RiskDataDTO.class,RiskData.class, false);
        List<RiskData> riskDataList= riskDataMapper.selectList(null);
        List<RiskDataDTO> riskDataDTOS=new ArrayList<>();
        beanCopier.copy(riskDataDTOS,riskDataList,null);
        return  riskDataDTOS;

    }


    public void auditDeclaration(String userId,String riskRating){
        User user =new User();
        user.setId(Integer.parseInt(userId));
        user.setRiskRating(riskRating);
        userMapper.updateById(user);
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

