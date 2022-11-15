package com.everysucceed;

import com.es.util.SqlSessionUtils;
import com.everysucceed.entity.News;
import com.everysucceed.mapper.NewsMapper;
import org.junit.Before;
import org.junit.Test;

public class Many2OneTest {

    NewsMapper mapper;

    @Before
    public void getMapper(){
        mapper = SqlSessionUtils.openSession().getMapper(NewsMapper.class);
    }



    @Test
    public void get(){
        News news = mapper.get(2);
        System.out.println(news.getNewsType());
    }

    @Test
    public void getByStep(){
        News news = mapper.getByStep(1);
        System.out.println(news.getContent());
        System.out.println("-----------------------------------");
       // System.out.println(news.getNewsType());
        System.out.println(news.getNewsType());
    }


}
