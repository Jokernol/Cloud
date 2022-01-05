package se.edu.badgateway.pojo.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class IndexHighRiskPeople {

    private String name;
    private String sex;
    private String telephone;
    private String habitation;
    private String healthCodeType;
    private String viaPlace;
    private String bodySituation;



}
