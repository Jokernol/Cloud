package se.edu.badgateway.pojo.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiskPlace {
    private int id;
    private String level;
    private Double X;
    private Double Y;
    private String intro;


}
