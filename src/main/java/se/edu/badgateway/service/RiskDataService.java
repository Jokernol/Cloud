package se.edu.badgateway.service;

import com.alibaba.fastjson.JSON;
import net.sf.cglib.beans.BeanCopier;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.edu.badgateway.mapper.RiskDataMapper;
import se.edu.badgateway.mapper.UserMapper;
import se.edu.badgateway.pojo.DO.RiskData;
import se.edu.badgateway.pojo.DO.User;
import se.edu.badgateway.pojo.DTO.RiskDataDTO;
import se.edu.badgateway.pojo.DTO.RiskPlaceDTO;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public List<RiskDataDTO> getAllRiskDataDto(){
        List<RiskData> riskDataList = riskDataMapper.selectList(null);
        List<RiskDataDTO> riskDataDTOS;
        riskDataDTOS = JSON.parseArray(JSON.toJSONString(riskDataList), RiskDataDTO.class);
        return  riskDataDTOS;

    }
}
