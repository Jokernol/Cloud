package se.edu.badgateway.pojo.DO;

import lombok.Data;

@Data
public class RiskData {
    private int id;
    private String temperature;
    private String bodySituation;
    private String viaPlace;
    private int userId;
}
