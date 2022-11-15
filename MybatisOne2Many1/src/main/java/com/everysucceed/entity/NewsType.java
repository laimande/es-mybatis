package com.everysucceed.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class NewsType {
    private Integer id;
    private String name;
    private String remark;

    List<News> newsList;
}
