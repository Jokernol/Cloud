package se.edu.badgateway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import se.edu.badgateway.mapper.UserMapper;
import se.edu.badgateway.pojo.DO.User;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class SimpleTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1() {
        List<User> users = userMapper.selectList(null);

        users.forEach(System.out::println);
    }

    @Test
    public void testAddUser() {
        userMapper.insert(new User());
    }
}
