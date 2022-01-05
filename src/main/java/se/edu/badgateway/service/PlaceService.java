package se.edu.badgateway.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.edu.badgateway.mapper.RiskPlaceMapper;
import se.edu.badgateway.pojo.DO.RiskPlace;
import se.edu.badgateway.pojo.DTO.RiskPlaceDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class PlaceService {


    @Autowired
    RiskPlaceMapper riskPlaceMapper;


    public  List<RiskPlaceDTO> getIndexRiskPlace(){
        List<RiskPlaceDTO> riskPlaceDTOS =new ArrayList<>();
        List<RiskPlace> riskPlaces=riskPlaceMapper.getAllRiskPlace();
        BeanUtils.copyProperties(riskPlaces, riskPlaceDTOS);
        return riskPlaceDTOS;
    }


    public void deleteRiskPlace(RiskPlaceDTO riskPlaceDTO){
        Map<String, Object> map = new HashMap<>();
        map.put("x",riskPlaceDTO.getX());
        map.put("y",riskPlaceDTO.getY());
        riskPlaceMapper.deleteByMap(map);
    }

    public void addRiskPlace(RiskPlaceDTO riskPlaceDTO, String intro){
        RiskPlace riskPlace =new RiskPlace();
        BeanUtils.copyProperties(riskPlace, riskPlaceDTO);
        riskPlace.setIntro(intro);
        riskPlaceMapper.insert(riskPlace);

    }
}
