package com.everysucceed.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SysRole {

    private Integer id;
    private String roleName;
    private String remark;

    List<SysResource> resources;
}
