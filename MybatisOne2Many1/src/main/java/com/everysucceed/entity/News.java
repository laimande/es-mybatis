package com.everysucceed.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class News {
    private Integer id;
    private String title;
    private String content;
    private Date publishDate;
    private String author;
    private NewsType newsType;
}
