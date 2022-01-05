package se.edu.badgateway.pojo.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class RiskPlaceDTO {
    private String level;
    private String x;
    private String y;
    private String intro;
}
