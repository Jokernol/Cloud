package se.edu.badgateway;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.BeanUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import se.edu.badgateway.mapper.RiskDataMapper;
import se.edu.badgateway.mapper.RiskPlaceMapper;
import se.edu.badgateway.mapper.UserMapper;
import se.edu.badgateway.pojo.DO.RiskData;
import se.edu.badgateway.pojo.DO.RiskPlace;
import se.edu.badgateway.pojo.DO.User;
import se.edu.badgateway.pojo.DTO.LoginUser;
import se.edu.badgateway.pojo.DTO.RegistUser;
import se.edu.badgateway.pojo.DTO.RiskDataDTO;
import se.edu.badgateway.pojo.DTO.RiskPlaceDTO;
import se.edu.badgateway.service.InfoService;
import se.edu.badgateway.service.PlaceService;
import se.edu.badgateway.service.RiskDataService;
import se.edu.badgateway.utils.QRCodeUtil;

import java.util.HashMap;
import java.util.LinkedList;
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
    @Autowired
    private InfoService infoService;
    @Autowired
    private RiskPlaceMapper riskPlaceMapper;

    @Autowired
    private RiskDataMapper riskDataMapper;

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
        String destPath = "src/main/webapp/public/static/qrcode/dog.jpg";
        //生成二维码
        QRCodeUtil.encode(text, destPath, 0xFF00FF00);
        // 解析二维码
        String str = QRCodeUtil.decode(destPath);
        // 打印出解析出的内容
        System.out.println(str);
    }

    @Test
    public void testGet() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "1");
        map.put("password", "1");

        RegistUser registUser = new RegistUser();
        registUser.setName("1");
        registUser.setPassword("1");

        System.out.println(userMapper.selectOne(new QueryWrapper<User>().allEq(BeanUtils.beanToMap(registUser))));
    }

    @Test
    public void testInfo() {
        infoService.getInfoList().forEach(System.out::println);
    }

    @Test
    public void  testNum(){
        QueryWrapper<RiskPlace> queryWrapper=new QueryWrapper();
        queryWrapper.eq("level","black");
        Integer num= Math.toIntExact(riskPlaceMapper.selectCount(queryWrapper));
        System.out.println(num);
    }



    @Test
    public void testAddPlace(){
        RiskPlace riskPlace =new RiskPlace();
        RiskPlaceDTO riskPlaceDTO=new RiskPlaceDTO("red","123","2222","123");
        org.springframework.beans.BeanUtils.copyProperties(riskPlaceDTO, riskPlace);
        System.out.println(riskPlace);
        riskPlaceMapper.insert(riskPlace);
    }

    @Test
    public void testDeletePlace(){
        RiskPlaceDTO riskPlaceDTO=new RiskPlaceDTO("22","22","22","yellow");
        Map<String, Object> map = new HashMap<>();
        map.put("x",riskPlaceDTO.getX());
        map.put("y",riskPlaceDTO.getY());
        riskPlaceMapper.deleteByMap(map);
    }

    @Test
    public void testgetIndexRiskPlace(){
        PlaceService placeService =new PlaceService();
        List<RiskPlaceDTO> riskPlaceDTOS= placeService.getIndexRiskPlace();
        System.out.println(riskPlaceDTOS);

    }


    @Test
    public  void  testDeclareRiskData(){
        RiskData riskData = new RiskData();
        RiskDataDTO riskDataDTO =new RiskDataDTO("30","30","30",1);
        org.springframework.beans.BeanUtils.copyProperties(riskDataDTO, riskData);

        riskDataMapper.insert(riskData);
    }

    @Test
    public void testGetAllRiskDataDto(){
        List<RiskDataDTO> riskDataDTOList=new LinkedList<RiskDataDTO>();
        riskDataDTOList = riskDataService.getAllRiskDataDto();
        System.out.println(riskDataDTOList);
    }
}

