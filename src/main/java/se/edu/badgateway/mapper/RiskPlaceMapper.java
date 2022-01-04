package se.edu.badgateway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import se.edu.badgateway.pojo.DO.RiskPlace;

import java.util.List;

public interface RiskPlaceMapper extends BaseMapper<RiskPlace> {
    @Select("select * from risk_place")
    List<RiskPlace> getAllRiskPlace();
}
