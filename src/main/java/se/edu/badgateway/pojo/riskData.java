package se.edu.badgateway.pojo;

import lombok.Data;

@Data
public class riskData {
    private Integer id;
    private String temperature;
    private String bodySituation;
    private String viaPlace;
    private Integer userId;
}
