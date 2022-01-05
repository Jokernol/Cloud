package se.edu.badgateway.pojo.DO;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String password;
    private String sex;
    private String telephone;
    private String habitation;
    private String idCard;
    private Integer riskRating;
    private Integer healthCodeType;
    private Integer type;
}
