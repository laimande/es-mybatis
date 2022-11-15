package com.everysucceed.Service;

import com.everysucceed.entity.BankAccount;

import java.util.List;

public interface BankAccountService {

    List<BankAccount> list(Integer pageNum, Integer pageSize);

}
