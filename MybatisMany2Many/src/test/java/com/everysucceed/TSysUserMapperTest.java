package com.everysucceed;

import com.es.util.SqlSessionUtils;
import com.everysucceed.entity.SysRole;
import com.everysucceed.entity.SysUser;
import com.everysucceed.mapper.SysRoleMapper;
import com.everysucceed.mapper.SysUserMapper;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TSysUserMapperTest {

    SysUserMapper mapper = null;
    SysRoleMapper roleMapper = null;
    @Before
    public void getMapper(){
        mapper = SqlSessionUtils.openSession().getMapper(SysUserMapper.class);
        roleMapper = SqlSessionUtils.openSession().getMapper(SysRoleMapper.class);
    }

    @Test
    public void save(){
        SysUser sysUser = new SysUser();
        sysUser.setUsername("xiaoheihei");
        sysUser.setPassword("123456");
        mapper.save(sysUser);
        System.out.println(sysUser.getId());
    }

    @Test
    public void grand(){
        //SysUser
        SysUser sysUser = mapper.get(14);
        System.out.println(sysUser);
        List<SysRole> list = roleMapper.list();
        list.forEach(System.out::println);
        sysUser.setRoles(list);
        mapper.revoke(sysUser);
        mapper.grand(sysUser);

    }

    @Test
    public void get(){
        SysUser user = mapper.get(14);
        System.out.println(user);
    }

    @Test
    public void login(){
        //
        SysUser sysUser = mapper.get(14);
        for (SysRole sysRole: sysUser.getRoles()){
            System.out.println(sysRole.getRoleName()+"------");
            SysRole sysRole1 = roleMapper.get(sysRole.getId());
            sysRole1.getResources().forEach(System.out::println);
        }
    }

}
