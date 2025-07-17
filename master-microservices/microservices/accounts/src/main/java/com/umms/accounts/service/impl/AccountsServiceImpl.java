package com.umms.accounts.service.impl;

import com.umms.accounts.dto.CustomerDto;
import com.umms.accounts.repository.AccountsRepository;
import com.umms.accounts.repository.CustomerRepository;
import com.umms.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {
    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {

    }
}
