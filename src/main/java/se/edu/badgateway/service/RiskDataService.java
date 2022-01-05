package se.edu.badgateway.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.edu.badgateway.mapper.RiskDataMapper;
import se.edu.badgateway.mapper.UserMapper;
import se.edu.badgateway.pojo.DO.RiskData;
import se.edu.badgateway.pojo.DO.User;
import se.edu.badgateway.pojo.DTO.RiskDataDTO;

import javax.annotation.Resource;

@Service
@Transactional
public class RiskDataService {
    @Resource
    RiskDataMapper riskDataMapper;

    @Resource
    UserMapper userMapper;

    public void declareRiskData(RiskDataDTO riskDataDTO) {
        RiskData riskData = new RiskData();

        BeanUtils.copyProperties(riskDataDTO, riskData);

        riskDataMapper.insert(riskData);

        Integer userId = riskDataDTO.getUserId();

        User user = userMapper.selectById(userId);
        user.setRiskRating("medium");

        userMapper.updateById(user);
    }
}
