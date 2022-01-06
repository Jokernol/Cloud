package se.edu.badgateway.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.edu.badgateway.mapper.RiskDataMapper;
import se.edu.badgateway.mapper.UserMapper;
import se.edu.badgateway.pojo.DO.RiskData;
import se.edu.badgateway.pojo.DO.User;
import se.edu.badgateway.pojo.DTO.RiskDataDTO;
import se.edu.badgateway.pojo.DTO.UserDTO;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    }



    public long getRiskDataDtoNum(){
        long num =riskDataMapper.selectCount(new QueryWrapper<RiskData>().eq("status", 0));
        return num;
    }

    public Map<UserDTO, RiskData> getAllRiskDataDto(){
        List<RiskData> riskDataList = riskDataMapper.selectList(new QueryWrapper<RiskData>().eq("status", 0));
        Map<UserDTO, RiskData> map = new HashMap<>();
        for (RiskData riskData : riskDataList) {
            User user = userMapper.selectById(riskData.getUserId());
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            map.put(userDTO, riskData);
        }
        return map;
    }
}
