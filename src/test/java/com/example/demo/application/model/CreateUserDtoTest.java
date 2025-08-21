// SPDX-FileCopyrightText: 2025 diggsweden/wallet-backend-reference
//
// SPDX-License-Identifier: EUPL-1.2
package com.example.demo.application.model;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Set;
import java.util.UUID;
import org.junit.Test;
import com.example.demo.infrastructure.model.UserEntity;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;


public class CreateUserDtoTest {

  @Test
  public void testValidationRules() {
    UserEntity userEntity = new UserEntity(UUID.randomUUID(), null, null, null);
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
    assertThat(violations)
        .hasSize(3)
        .anySatisfy(v -> assertThat(v.getPropertyPath()).hasToString("name"))
        .anySatisfy(v -> assertThat(v.getPropertyPath()).hasToString("address"))
        .anySatisfy(v -> assertThat(v.getPropertyPath()).hasToString("birthDate"));
  }
}
