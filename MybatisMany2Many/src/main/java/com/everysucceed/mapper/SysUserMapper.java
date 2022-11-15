package com.everysucceed.mapper;

import com.everysucceed.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {

    /**
     * @param sysUser
     * @return
     */
    int save(SysUser sysUser);

    /**
     * @return
     */
    List<SysUser> list();

    /**
     * @param id
     * @return
     */
    SysUser get(@Param("id") Integer id);

    int grand(SysUser sysUser);

    int revoke(SysUser sysUser);
}
