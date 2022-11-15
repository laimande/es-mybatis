package com.everysucceed.mapper;

import com.everysucceed.entity.News;

import java.util.List;

public interface NewsMapper {

    List<News> list(News news);

    int update(News news);
}
