package se.edu.badgateway;

import com.baomidou.mybatisplus.core.toolkit.BeanUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import se.edu.badgateway.mapper.UserMapper;
import se.edu.badgateway.pojo.DO.User;
import se.edu.badgateway.pojo.DTO.LoginUser;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class SimpleTest {
    private static Logger logger = Logger.getLogger(SimpleTest.class);

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1() {
        List<User> users = userMapper.selectList(null);

        users.forEach(System.out::println);
    }

    @Test
    public void testAddUser() {
        LoginUser loginUser = new LoginUser("admin", "admin");

        Map<String, Object> map = BeanUtils.beanToMap(loginUser);

        userMapper.selectByMap(map);
    }
}
