package com.umms.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerUpdateDto {
    @Size(min = 5, max = 30, message = "name length should be between 5 and 30 caracteres")
    private String name;

    @Email(message = "Email address is invalid")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number length must be 10 digits")
    private String mobileNumber;

    private AccountUpdateDto account;
}
