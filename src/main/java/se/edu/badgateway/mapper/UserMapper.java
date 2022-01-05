package se.edu.badgateway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import se.edu.badgateway.pojo.DO.User;
import se.edu.badgateway.pojo.DTO.IndexHighRiskPeople;

import java.util.List;


public interface UserMapper extends BaseMapper<User> {
    /*
    @Select("select * from user where name=#{arg0} AND password=#{arg1};")
    User login(String name, String password);

     */


    @Select("select u.name,u.sex,u.telephone,u.habitation,u.health_code_type,rd.via_place,rd.body_situation from user u,risk_data rd Where u.id=rd.user_id AND u.risk_rating=3; ")
    List<IndexHighRiskPeople> getHighRiskPeople();
}
