package com.everysucceed;

import com.es.util.SqlSessionUtils;
import com.everysucceed.entity.TbGoods;
import com.everysucceed.mapper.TbGoodsMapper;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TbGoodsMapperTest {

    TbGoodsMapper mapper;

    @Before
    public void getMapper(){
        mapper = SqlSessionUtils.openSession().getMapper(TbGoodsMapper.class);
    }


    @Test
    public void list(){
        List<TbGoods> list = mapper.list();
        System.out.println(list.size());
        System.out.println(list.get(0));

        /*
        for (TbGoods tbGoods: list) {
            System.out.println(tbGoods);
        }
        */

    }
    @Test
    public void listGoods(){
        List<TbGoods> list = mapper.listGoods();
        System.out.println(list.size());
        list.forEach(System.out::println);
       // System.out.println(list.get(0));

        /*
        for (TbGoods tbGoods: list) {
            System.out.println(tbGoods);
        }
        */

    }


    @Test
    public void get(){
        TbGoods goods = mapper.get(1L);
        System.out.println(goods);
    }

}
