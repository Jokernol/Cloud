package se.edu.badgateway.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.edu.badgateway.mapper.RiskPlaceMapper;
import se.edu.badgateway.pojo.DO.RiskPlace;
import se.edu.badgateway.pojo.DTO.IndexRiskPlace;

import java.util.ArrayList;
import java.util.List;


@Component
public class PlaceService {


    @Autowired
    RiskPlaceMapper riskPlaceMapper;


    public  List<IndexRiskPlace> getIndexRiskPlace(){
        List<IndexRiskPlace> indexRiskPlaces =new ArrayList<>();
        List<RiskPlace> riskPlaces=riskPlaceMapper.getAllRiskPlace();
        BeanUtils.copyProperties(riskPlaces,indexRiskPlaces);
        return indexRiskPlaces;
    }
}
