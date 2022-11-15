package com.everysucceed.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SysResource {
    private Integer id;
    private String name;
    private String url ;
    private String icon;
    private String remark ;
    private Integer seq;
    private Byte type;
    //pid int,
    List<SysResource> children;
}
