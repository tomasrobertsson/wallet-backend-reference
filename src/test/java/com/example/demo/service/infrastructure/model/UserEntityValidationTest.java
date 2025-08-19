// SPDX-FileCopyrightText: 2025 diggsweden/wallet-backend-reference
//
// SPDX-License-Identifier: EUPL-1.2
package com.example.demo.service.infrastructure.model;

import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.UUID;
import org.junit.Test;
import com.example.demo.AbstractValidationTest;
import com.example.demo.infrastructure.model.UserEntity;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class UserEntityValidationTest extends AbstractValidationTest<UserEntity> {
  Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  @Test
  public void testGivEntityEmptyName() {
    assertThat(
        givenEmptyName(
            new UserEntity(UUID.randomUUID(), "adress", "", LocalDate.of(2024, 1, 1))))
        .isTrue();
  }


  @Test
  public void testGivenNoBirthDate() {
    assertThat(givenNoBirthDate(new UserEntity(UUID.randomUUID(), "adress", "My name", null)))
        .isTrue();

  }

  @Test
  public void testGivenNoAddress() {

    assertThat(givenNoAddress(
        new UserEntity(UUID.randomUUID(), "", "My name", LocalDate.of(2024, 1, 1))))
        .isTrue();
  }
}
