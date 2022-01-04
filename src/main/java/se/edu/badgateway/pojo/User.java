package se.edu.badgateway.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private String sex;
    private String telephone;
    private String habitation;
    private String idCard;
    private String riskRating;
    private String healthCodeType;
    private Integer type;
}
