package com.everysucceed.mapper;

import com.everysucceed.entity.SysResource;

import java.util.List;

public interface SysResourceMapper {

    /**
     * @param sysResource
     * @return
     */
    int save(SysResource sysResource);

    /**
     * @return
     */
    List<SysResource> list();

}
