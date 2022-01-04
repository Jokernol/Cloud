package se.edu.badgateway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import se.edu.badgateway.pojo.DO.User;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
