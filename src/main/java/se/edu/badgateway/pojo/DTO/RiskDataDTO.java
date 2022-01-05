package se.edu.badgateway.pojo.DTO;

import lombok.Data;

@Data
public class RiskDataDTO {
    private String temperature;
    private String bodySituation;
    private String viaPlace;
    private int userId;
}
