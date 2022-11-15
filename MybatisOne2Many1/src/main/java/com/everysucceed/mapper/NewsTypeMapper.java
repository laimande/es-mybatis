package com.everysucceed.mapper;

import com.everysucceed.entity.NewsType;

public interface NewsTypeMapper {

    /**
     * @param id
     * @return
     */
    NewsType get(Integer id);

    /**
     * @param id
     * @return
     */
    NewsType getOne2Many(Integer id);


    /**
     * @param id
     * @return
     */
    NewsType getOne2ManyStep(Integer id);

}
