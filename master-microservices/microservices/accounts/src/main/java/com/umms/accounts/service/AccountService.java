package com.umms.accounts.service;

import com.umms.accounts.dto.CustomerDto;
import com.umms.accounts.dto.CustomerUpdateDto;

public interface AccountService {
    /**
     *
     * @param customerDto CustomerDto Object
     */
    CustomerDto createCustomerAndAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber Customer mobile number
     * @return CustomerDto Object
     */
    CustomerDto fetchAccount(String mobileNumber);

    /**
     *
     * @param customerId CustomerUpdateDto customer id and customer update dto
     * @return CustomerDto Object
     */
    CustomerDto updateAccount(long customerId, CustomerUpdateDto customerUpdateDto);

    /**
     *
     * @param mobileNumber Customer mobile number
     */
    void deleteAccount(String mobileNumber);
}
