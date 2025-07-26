package com.umms.accounts.controller;

import com.umms.accounts.dto.CustomerDto;
import com.umms.accounts.dto.CustomerUpdateDto;
import com.umms.accounts.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/account", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountController {
    private AccountService accountsService;

    @PostMapping()
    public ResponseEntity<CustomerDto> createAccount(@RequestBody CustomerDto customerDto) {
        CustomerDto customerCreatedDto = accountsService.createCustomerAndAccount(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerCreatedDto);
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccount(@RequestParam String mobileNumber) {
        CustomerDto customerDto = accountsService.fetchAccount(mobileNumber);
        return ResponseEntity.ok(customerDto);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDto> updateAccount(@RequestParam long customerId, @RequestBody CustomerUpdateDto customerUpdateDto) {
        CustomerDto customerDto = accountsService.updateAccount(customerId, customerUpdateDto);
        return ResponseEntity.ok(customerDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteAccount(@RequestParam String mobileNumber) {
        accountsService.deleteAccount(mobileNumber);
        return ResponseEntity.noContent().build();
    }

}
