package com.umms.accounts.service.impl;

import com.umms.accounts.contants.AccountConstants;
import com.umms.accounts.dto.AccountUpdateDto;
import com.umms.accounts.dto.CustomerDto;
import com.umms.accounts.dto.CustomerUpdateDto;
import com.umms.accounts.entity.Account;
import com.umms.accounts.entity.Customer;
import com.umms.accounts.exception.CustomerAlreadyExistsException;
import com.umms.accounts.exception.ResourceNotFoundException;
import com.umms.accounts.mapper.CustomerMapper;
import com.umms.accounts.repository.AccountRepository;
import com.umms.accounts.repository.CustomerRepository;
import com.umms.accounts.service.AccountService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountsRepository;
    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public CustomerDto createCustomerAndAccount(CustomerDto customerDto) {
        String mobileNumber = customerDto.getMobileNumber();
        customerRepository.findByMobileNumber(mobileNumber).ifPresent(customer -> {
            throw new CustomerAlreadyExistsException("Customer already registered with given mobile number: " + mobileNumber);
        });
        String email = customerDto.getEmail();
        customerRepository.findByEmail(email).ifPresent(customer -> {
            throw new CustomerAlreadyExistsException("Customer already registered with given email: " + email);
        });
        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        customer.setAccount(createNewAccount(customer));
        Customer customerCreated = customerRepository.save(customer);
        return CustomerMapper.mapToCustomerDto(customerCreated);
    }

    private Account createNewAccount(Customer customer) {
        Account account = new Account();
        account.setCustomer(customer);
        account.setAccountNumber(generateAccountNumber());
        account.setAccountType(AccountConstants.SAVINGS);
        account.setBranchAddress(AccountConstants.ADDRESS);
        return account;
    }

    private long generateAccountNumber() {
        return 1000000000L + new Random().nextInt(900000000);
    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        return CustomerMapper.mapToCustomerDto(customer);
    }

    @Override
    @Transactional
    public CustomerDto updateAccount(long customerId, CustomerUpdateDto customerUpdateDto) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "customerId", String.valueOf(customerId))
        );
        if (customerUpdateDto.getName() != null) {
            customer.setName(customerUpdateDto.getName());
        }
        if (customerUpdateDto.getEmail() != null) {
            customer.setEmail(customerUpdateDto.getEmail());
        }
        AccountUpdateDto accountUpdateDto = customerUpdateDto.getAccount();
        if (accountUpdateDto != null) {
            Account account = customer.getAccount();
            if (account == null) {
                throw new ResourceNotFoundException("Account", "customerId", String.valueOf(customerId));
            }
            if (accountUpdateDto.getAccountType() != null) {
                account.setAccountType(accountUpdateDto.getAccountType());
            }
            if (accountUpdateDto.getBranchAddress() != null) {
                account.setBranchAddress(accountUpdateDto.getBranchAddress());
            }
        }
        Customer updatedCustomer = customerRepository.save(customer);
        return CustomerMapper.mapToCustomerDto(updatedCustomer);
    }

    @Override
    @Transactional
    public void deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        customerRepository.delete(customer);
    }
}
