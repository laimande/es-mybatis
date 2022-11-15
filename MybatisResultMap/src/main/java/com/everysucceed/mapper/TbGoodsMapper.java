package com.everysucceed.mapper;

import com.everysucceed.entity.TbGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbGoodsMapper {

    /**
     * 查询所有的 商品信息
     * @return
     */
    List<TbGoods> list();

    List<TbGoods> listGoods();

    /**
     * @param id
     * @return
     */
    TbGoods get(@Param("id") Long id);

}
