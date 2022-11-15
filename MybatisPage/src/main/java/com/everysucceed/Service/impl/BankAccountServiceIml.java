package com.everysucceed.Service.impl;

import com.es.util.SqlSessionUtils;
import com.everysucceed.Service.BankAccountService;
import com.everysucceed.entity.BankAccount;
import com.everysucceed.mapper.BankAccountMapper;
import com.github.pagehelper.PageHelper;

import java.util.List;

public class BankAccountServiceIml implements BankAccountService {

    BankAccountMapper mapper = SqlSessionUtils.openSession().getMapper(BankAccountMapper.class);
    @Override
    public List<BankAccount> list(Integer pageNum, Integer pageSize) {
        //进行分页
        PageHelper.startPage(pageNum, pageSize);
        List<BankAccount> list = mapper.list();
        return list;
    }
}
