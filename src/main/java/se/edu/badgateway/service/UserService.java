package se.edu.badgateway.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.BeanUtils;
import net.sf.cglib.beans.BeanCopier;
import org.springframework.stereotype.Component;
import se.edu.badgateway.mapper.RiskDataMapper;
import se.edu.badgateway.mapper.UserMapper;
import se.edu.badgateway.pojo.DO.User;
import se.edu.badgateway.pojo.DTO.IndexHighRiskPeople;
import se.edu.badgateway.pojo.DTO.LoginUser;
import se.edu.badgateway.pojo.DTO.RegistUser;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private RiskDataMapper riskDataMapper;

    @Resource
    QRCodeService qrCodeService;

    @Resource
    RiskDataService riskDataService;

    public boolean userRegist(RegistUser registUser){
        final BeanCopier beanCopier = BeanCopier.create(RegistUser.class,User.class, false);
        User user=new User();
        beanCopier.copy(registUser,user,null);
        userMapper.insert(user);

        Map<String, Object> map = new HashMap<>();
        map.put("name", user.getName());
        map.put("password", user.getPassword());

        List<User> userList = userMapper.selectByMap(map);

        qrCodeService.encodeGrey(userList.get(0).getId());
        return true;
    }



    public List<IndexHighRiskPeople> getAllHighRiskPeople(){
        return userMapper.getHighRiskPeople();
    }

    public void auditDeclaration(Integer userId, Integer riskRating){
        User user =new User();
        user.setId(userId);
        user.setRiskRating(riskRating);
        userMapper.updateById(user);
        riskDataService.changeRiskDataStatus(userId);
        switch (riskRating) {
            case 0: qrCodeService.encodeGreen(userId); break;
            case 2: qrCodeService.encodeRed(userId); break;
        }
    }

    public Integer getAllHighPeopleNum(){
        return Math.toIntExact(userMapper.selectCount(new QueryWrapper<User>()
                                                        .eq("risk_rating",2)));
    }

    public Integer userLogin(LoginUser loginUser, HttpSession session) {
        Map<String, Object> map = BeanUtils.beanToMap(loginUser);
        List<User> users = userMapper.selectByMap(map);

        if (users == null || users.isEmpty()) {
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

