package com.example.demo.application.model;

import java.time.LocalDate;

// TODO validate?
public record UserDto(
        String address,
        String name,
        LocalDate birthDate) {

}