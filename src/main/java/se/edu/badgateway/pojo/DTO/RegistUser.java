package se.edu.badgateway.pojo.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class RegistUser {
    private String name;
    private String password;
    private String sex;
    private String telephone;
    private String habitation;
    private String idCard;
    private String riskRating;
    private String healthCodeType;
}
