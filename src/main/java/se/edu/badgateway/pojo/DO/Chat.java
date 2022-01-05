package se.edu.badgateway.pojo.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    private int id;
    private int senderId;
    private int receiverId;
    private String content;
    private LocalDate time;
    private int isRead;
}
