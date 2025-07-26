package com.umms.accounts.mapper;

import com.umms.accounts.dto.AccountDto;
import com.umms.accounts.entity.Account;

public class AccountMapper {
    public static AccountDto mapToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setAccountType(account.getAccountType());
        accountDto.setBranchAddress(account.getBranchAddress());
        return accountDto;
    }

    public static Account mapToAccount(AccountDto accountDto) {
        Account accounts = new Account();
        accounts.setAccountNumber(accountDto.getAccountNumber());
        accounts.setAccountType(accountDto.getAccountType());
        accounts.setBranchAddress(accountDto.getBranchAddress());
        return accounts;
    }
}
