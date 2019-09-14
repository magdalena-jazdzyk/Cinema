package com.app.cinema.dto;

import com.app.cinema.model.LoyaltyCard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PremiumUserDto {

    private Long id;
    private String username;
    private String name;
    private String surname;
    private String email;
    private Integer age;
    private String password;
    private String passwordConfirmation;
    private LoyaltyCard loyaltyCard;
}