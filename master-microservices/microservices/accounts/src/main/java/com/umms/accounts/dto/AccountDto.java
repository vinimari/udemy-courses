package com.umms.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AccountDto {
    @NotEmpty(message = "AccountNumber cannot be null or empty")
    private Long accountNumber;

    @NotEmpty(message = "AccountType cannot be null or empty")
    private String accountType;

    @NotEmpty(message = "branchAddress cannot be null or empty")
    private String branchAddress;
}
