// SPDX-FileCopyrightText: 2025 diggsweden/wallet-backend-reference
//
// SPDX-License-Identifier: EUPL-1.2
package com.example.demo.service.infrastructure.model;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import org.junit.Test;
import com.example.demo.infrastructure.model.UserEntity;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class UserEntityValidationTest {

  @Test
  public void testValidationOK() {
    UserEntity userEntity =
        new UserEntity(UUID.randomUUID(), "an address", "my name", LocalDate.of(2024, 1, 1));
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
    assertThat(violations).isEmpty();
  }


  @Test
  public void testValidationError() {
    UserEntity userEntity = new UserEntity(UUID.randomUUID(), null, null, null);
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
    assertThat(violations)
        .hasSize(1)
        .allSatisfy(v -> assertThat(v.getPropertyPath()).hasToString("name"))
        .allSatisfy(v -> assertThat(v.getMessage()).contains("null"));
  }

}


