package com.everysucceed.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class IdCard {

    private String id;
    private Date expDateStart;
    private Date expDateEnd;
}
