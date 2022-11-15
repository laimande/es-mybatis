package com.everysucceed;

import com.es.util.SqlSessionUtils;
import com.everysucceed.entity.News;
import com.everysucceed.mapper.NewsMapper;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class NewsTest {

    NewsMapper mapper ;
    @Before
    public void getMapper(){
        mapper = SqlSessionUtils.openSession().getMapper(NewsMapper.class);
    }

    @Test
    public void list(){
        News news = new News();
        news.setAuthor("%白%");
        news.setPublishDate(Date.from(Instant.from(LocalDate.of(2022,11,11).atStartOfDay().atZone(ZoneId.systemDefault()))));
        List<News> list = mapper.list(news);
        list.forEach(System.out::println);
    }

    @Test
    public void update(){
        News news = new News();
        news.setId(3);
        news.setTitle("这个挺好的吗？");
        news.setAuthor("小红");
        mapper.update(news);
    }
}
