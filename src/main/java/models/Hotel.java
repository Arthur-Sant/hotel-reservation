package models;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    private String id;
    private String name;
    private Date date;
    private Float diaryRegular;
    private Float diaryReward;

}