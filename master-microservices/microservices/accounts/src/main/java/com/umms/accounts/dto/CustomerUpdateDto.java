package com.umms.accounts.dto;

import lombok.Data;

@Data
public class CustomerUpdateDto {
    private String name;
    private String email;
    private String mobileNumber;
    private AccountUpdateDto account;
}
