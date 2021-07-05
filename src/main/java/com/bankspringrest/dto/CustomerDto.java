package com.bankspringrest.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDto {
    private Integer customerId;
    private String emailId;
    private String name;
    private LocalDate dateOfBirth;


}
