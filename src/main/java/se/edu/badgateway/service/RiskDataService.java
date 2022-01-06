package se.edu.badgateway.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.edu.badgateway.mapper.RiskDataMapper;
import se.edu.badgateway.mapper.UserMapper;
import se.edu.badgateway.pojo.DO.Chat;
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
        long num =riskDataMapper.selectCount(new QueryWrapper<RiskData>().eq("status","0"));
        return num;
    }

    public Map<UserDTO, RiskDataDTO> getAllRiskDataDto(){
        List<RiskData> riskDataList = riskDataMapper.selectList(new QueryWrapper<RiskData>().eq("status", 0));
        Map<UserDTO, RiskDataDTO> map = new HashMap<>();
        for (RiskData riskData : riskDataList) {
            User user = userMapper.selectById(riskData.getUserId());
            UserDTO userDTO = new UserDTO();
            RiskDataDTO riskDataDTO=new RiskDataDTO();
            BeanUtils.copyProperties(riskData, riskDataDTO);
            BeanUtils.copyProperties(user, userDTO);
            map.put(userDTO, riskDataDTO);
        }
        return map;
    }

    public void changeRiskDataStatus(Integer userId){
        UpdateWrapper<RiskData> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id",userId);
        RiskData riskData =new RiskData();
        riskData.setStatus(1);
        riskDataMapper.update(riskData,updateWrapper);
    }
}
