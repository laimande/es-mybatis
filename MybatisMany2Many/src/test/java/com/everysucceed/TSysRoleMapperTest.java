package com.everysucceed;

import com.es.util.SqlSessionUtils;
import com.everysucceed.entity.SysResource;
import com.everysucceed.entity.SysRole;
import com.everysucceed.entity.SysUser;
import com.everysucceed.mapper.SysResourceMapper;
import com.everysucceed.mapper.SysRoleMapper;
import com.everysucceed.mapper.SysUserMapper;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TSysRoleMapperTest {

    SysRoleMapper mapper = null;
    SysResourceMapper resourceMapper = null;
    @Before
    public void getMapper(){

        mapper = SqlSessionUtils.openSession().getMapper(SysRoleMapper.class);
        resourceMapper = SqlSessionUtils.openSession().getMapper(SysResourceMapper.class);
    }

    @Test
    public void save(){
        //for(int i=1){}
        /*
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("CEO");
        sysRole.setRemark("首席执行官");

        SysRole sysRole1 = new SysRole();
        sysRole1.setRoleName("CTO");
        sysRole1.setRemark("首席技术官");
        */
        SysRole sysRole2 = new SysRole();
        sysRole2.setRoleName("程序员");
        sysRole2.setRemark("写代码的");

        mapper.save(sysRole2);
       // mapper.save(sysRole1);
       // System.out.println(sysUser.getId());
    }

    @Test
    public void grand(){
        //SysUser
        SysRole sysRole = mapper.get(2);
        System.out.println(sysRole.getRoleName());

        List<SysResource> list = resourceMapper.list();
        mapper.revoke(sysRole);
        sysRole.setResources(list);
        mapper.grand(sysRole);
    }

}
