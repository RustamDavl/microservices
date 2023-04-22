package com.rustdv.customer.entity;

import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerRequest {

    private String firstName;
    private String lastName;
    private String email;
}
