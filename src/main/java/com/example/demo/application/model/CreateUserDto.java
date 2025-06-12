package com.example.demo.application.model;

import java.time.LocalDate;

// TODO validate?
public record CreateUserDto(
        String address,
        String name,
        LocalDate birthDate) {

}