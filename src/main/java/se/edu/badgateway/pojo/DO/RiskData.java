package se.edu.badgateway.pojo.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiskData {
    private int id;
    private String temperature;
    private String bodySituation;
    private String viaPlace;
    private int userId;
    private int status;
}
