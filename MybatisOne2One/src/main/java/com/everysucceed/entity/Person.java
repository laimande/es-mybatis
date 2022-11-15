package com.everysucceed.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {

    private Integer id;
    private String name;
    private IdCard idCard;

}
