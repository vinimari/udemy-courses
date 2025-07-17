package com.umms.accounts.service;

import com.umms.accounts.dto.CustomerDto;

public interface IAccountsService {
    /**
     *
     * @param customerDto CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);
}
