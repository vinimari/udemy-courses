package com.umms.accounts.dto;

import lombok.Data;

@Data
public class AccountDto {
    private Long accountNumber;
    private String accountType;
    private String branchAddress;
}
