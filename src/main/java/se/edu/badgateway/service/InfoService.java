package se.edu.badgateway.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.edu.badgateway.mapper.InfoMapper;
import se.edu.badgateway.pojo.DO.Info;
import se.edu.badgateway.pojo.DTO.InfoDTO;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class InfoService {
    @Resource
    InfoMapper infoMapper;

    public void addInfo(InfoDTO infoDTO) {
        Info info = new Info();
        info.setTime(LocalDateTime.now());
        BeanUtils.copyProperties(infoDTO, info);

        infoMapper.insert(info);
    }

    public void deleteInfo(Integer id) {
        infoMapper.deleteById(id);
    }

    public List<Info> getInfoList() {
        return infoMapper.selectList(new QueryWrapper<Info>().orderByDesc("time"));
    }
}
