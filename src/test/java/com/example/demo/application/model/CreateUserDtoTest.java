// SPDX-FileCopyrightText: 2025 diggsweden/wallet-backend-reference
//
// SPDX-License-Identifier: EUPL-1.2
package com.example.demo.application.model;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;
import java.util.Set;
import org.junit.Test;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;


public class CreateUserDtoTest {

  @Test
  public void testValidationOK() {
    CreateUserDto user = new CreateUserDto("an address", "my name", LocalDate.of(2024, 1, 1));
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<CreateUserDto>> violations = validator.validate(user);
    assertThat(violations).isEmpty();
  }

  @Test
  public void testValidationErrors() {
    CreateUserDto user = new CreateUserDto(null, null, null);
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<CreateUserDto>> violations = validator.validate(user);
    assertThat(violations)
        .anySatisfy(v -> {
          assertThat(v.getPropertyPath()).hasToString("name");
          assertThat(v.getMessage()).contains("blank");
        })

        .anySatisfy(v -> {
          assertThat(v.getPropertyPath()).hasToString("address");
          assertThat(v.getMessage()).contains("blank");
        })
        .anySatisfy(v -> {
          assertThat(v.getPropertyPath()).hasToString("birthDate");
          assertThat(v.getMessage()).contains("null");
        })
        .hasSize(3);
  }
}
