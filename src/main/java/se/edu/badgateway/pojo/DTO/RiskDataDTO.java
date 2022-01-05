package se.edu.badgateway.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiskDataDTO {
    private String temperature;
    private String bodySituation;
    private String viaPlace;
    private int userId;
}
