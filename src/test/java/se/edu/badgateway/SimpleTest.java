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
import se.edu.badgateway.pojo.DTO.RiskDataDTO;
import se.edu.badgateway.service.RiskDataService;
import se.edu.badgateway.utils.QRCodeUtil;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class SimpleTest {
    private static final Logger logger = Logger.getLogger(SimpleTest.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RiskDataService riskDataService;

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

    @Test
    public void testAddUser1() {
        RiskDataDTO riskDataDTO = new RiskDataDTO();
        riskDataDTO.setUserId(5);
        riskDataService.declareRiskData(riskDataDTO);
    }

    @Test
    public void testQRCode() {
        // 存放在二维码中的内容
        String text = "hello";
        // 生成的二维码的路径及名称
        String destPath = "src/main/webapp/qrcode/dog.jpg";
        //生成二维码
        QRCodeUtil.encode(text, destPath, 0xFF00FF00);
        // 解析二维码
        String str = QRCodeUtil.decode(destPath);
        // 打印出解析出的内容
        System.out.println(str);
    }
}
