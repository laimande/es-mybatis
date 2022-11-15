package com.everysucceed;

import com.es.util.SqlSessionUtils;
import com.everysucceed.entity.News;
import com.everysucceed.entity.NewsType;
import com.everysucceed.mapper.NewsMapper;
import com.everysucceed.mapper.NewsTypeMapper;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class One2ManyTest {

    NewsTypeMapper mapper;

    @Before
    public void getMapper(){
        mapper = SqlSessionUtils.openSession().getMapper(NewsTypeMapper.class);
    }



    @Test
    public void get(){
        NewsType newsType = mapper.getOne2Many(1);
        System.out.println(newsType);
    }

    @Test
    public void getByStep(){
        NewsType type = mapper.getOne2ManyStep(1);
        System.out.println(type.getName());
        System.out.println("----------------------");
        List<News> list = type.getNewsList();
        list.forEach(System.out::println);
    }


}
