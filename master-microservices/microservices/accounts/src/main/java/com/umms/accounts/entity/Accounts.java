package com.umms.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Accounts extends BaseEntity {
    @Id
    private Long accountNumber;
    private String accountType;
    private Integer customerId;
    private String branchAddress;
}
