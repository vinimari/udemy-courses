package com.umms.accounts.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AccountUpdateDto {
    @Size(min = 5, max = 30, message = "accountType length should be between 5 and 30 caracteres")
    private String accountType;

    @Size(min = 5, max = 30, message = "branchAddress length should be between 5 and 30 caracteres")
    private String branchAddress;
}
