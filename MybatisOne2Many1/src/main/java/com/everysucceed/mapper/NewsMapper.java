package com.everysucceed.mapper;

import com.everysucceed.entity.News;

public interface NewsMapper {

    /**
     * @param id
     * @return
     */
    News get(Integer id);

    /**
     * @param id
     * @return
     */
    News getByStep(Integer id);

}
