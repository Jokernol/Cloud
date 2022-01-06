package se.edu.badgateway.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.edu.badgateway.mapper.RiskPlaceMapper;
import se.edu.badgateway.pojo.DO.RiskPlace;
import se.edu.badgateway.pojo.DTO.RiskPlaceDTO;
import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class PlaceService {


    @Autowired
    RiskPlaceMapper riskPlaceMapper;


    public  List<RiskPlace> getIndexRiskPlace(){
        List<RiskPlace> riskPlaces=riskPlaceMapper.getAllRiskPlace();
        return riskPlaces;
    }


    public void deleteRiskPlace(RiskPlaceDTO riskPlaceDTO){
        Map<String, Object> map = new HashMap<>();
        map.put("x",riskPlaceDTO.getX());
        map.put("y",riskPlaceDTO.getY());
        riskPlaceMapper.deleteByMap(map);
    }

    public void addRiskPlace(RiskPlace riskPlace){
        riskPlaceMapper.insert(riskPlace);

    }


    public Integer getAllRiskPlaceNum(){
        QueryWrapper<RiskPlace> queryWrapper=new QueryWrapper();
        Integer num= Math.toIntExact(riskPlaceMapper.selectCount(queryWrapper));
        return num;
    }


    public Integer getLowRiskPlaceNum(){
        QueryWrapper<RiskPlace> queryWrapper=new QueryWrapper();
        queryWrapper.eq("level","yellow");
        Integer num= Math.toIntExact(riskPlaceMapper.selectCount(queryWrapper));
        return num;
    }

    public Integer getHighRiskPlaceNum(){
        QueryWrapper<RiskPlace> queryWrapper=new QueryWrapper();
        queryWrapper.eq("level","red");
        Integer num= Math.toIntExact(riskPlaceMapper.selectCount(queryWrapper));
        return num;
    }



}
