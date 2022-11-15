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

public class TSysResourceMapperTest {

    SysResourceMapper mapper = null;
    @Before
    public void getMapper(){
        mapper = SqlSessionUtils.openSession().getMapper(SysResourceMapper.class);
    }

    @Test
    public void save(){

        SysResource sysResource = new SysResource();
        sysResource.setName("增加学生");
        sysResource.setUrl("/student/add");

        SysResource sysResource1 = new SysResource();
        sysResource1.setName("修改学生");
        sysResource1.setUrl("/student/update");

        SysResource sysResource2 = new SysResource();
        sysResource2.setName("删除学生");
        sysResource2.setUrl("/student/delete");

        SysResource sysResource3 = new SysResource();
        sysResource3.setName("查看学生");
        sysResource3.setUrl("/student/query");

        mapper.save(sysResource);
        mapper.save(sysResource1);
        mapper.save(sysResource2);
        mapper.save(sysResource3);

    }


}
