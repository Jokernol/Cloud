package se.edu.badgateway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import se.edu.badgateway.pojo.DO.User;


public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where name=#{arg0} AND password=#{arg1};")
    User login(String name, String password);
}
