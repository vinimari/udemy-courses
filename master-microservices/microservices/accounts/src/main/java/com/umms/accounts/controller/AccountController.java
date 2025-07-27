package com.umms.accounts.controller;

import com.umms.accounts.dto.CustomerDto;
import com.umms.accounts.dto.CustomerUpdateDto;
import com.umms.accounts.service.AccountService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/accounts", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class AccountController {
    private AccountService accountsService;

    @PostMapping()
    public ResponseEntity<CustomerDto> createAccount(@RequestBody @Valid CustomerDto customerDto) {
        CustomerDto customerCreatedDto = accountsService.createCustomerAndAccount(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerCreatedDto);
    }

    @GetMapping("/{mobileNumber}")
    public ResponseEntity<CustomerDto> fetchAccount(@PathVariable String mobileNumber) {
        CustomerDto customerDto = accountsService.fetchAccount(mobileNumber);
        return ResponseEntity.ok(customerDto);
    }

    @PatchMapping("/{customerId}")
    public ResponseEntity<CustomerDto> updateAccount(
            @PathVariable long customerId,
            @RequestBody @Valid CustomerUpdateDto customerUpdateDto
    ) {
        CustomerDto customerDto = accountsService.updateAccount(customerId, customerUpdateDto);
        return ResponseEntity.ok(customerDto);
    }

    @DeleteMapping("/{mobileNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(
            @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number length must be 10 digits") String mobileNumber) {
        accountsService.deleteAccount(mobileNumber);
    }
}
