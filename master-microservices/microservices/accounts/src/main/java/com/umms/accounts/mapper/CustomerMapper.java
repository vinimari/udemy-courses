package com.umms.accounts.mapper;

import com.umms.accounts.dto.AccountDto;
import com.umms.accounts.dto.CustomerDto;
import com.umms.accounts.entity.Customer;

public class CustomerMapper {
    public static CustomerDto mapToCustomerDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        customerDto.setAccount(AccountMapper.mapToAccountDto(customer.getAccount()));
        return customerDto;
    }

    public static Customer mapToCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        AccountDto accountDto = customerDto.getAccount();
        if (accountDto != null) {
            customer.setAccount(AccountMapper.mapToAccount(accountDto));
        }
        return customer;
    }
}
