package com.everysucceed.mapper;

import com.everysucceed.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper {

    /**
     * @param sysRole
     * @return
     */
    int save(SysRole sysRole);


    /**
     * @return
     */
    List<SysRole> list();

    /**
     * @param sysRole
     * @return
     */
    int grand(SysRole sysRole);

    int revoke(SysRole sysRole);


    /**
     * @param id
     * @return
     */
    SysRole get(@Param("id") Integer id);

}
