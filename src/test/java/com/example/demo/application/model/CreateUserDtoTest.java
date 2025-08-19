// SPDX-FileCopyrightText: 2025 diggsweden/wallet-backend-reference
//
// SPDX-License-Identifier: EUPL-1.2
package com.example.demo.application.model;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;
import org.junit.Test;
import com.example.demo.AbstractValidationTest;


public class CreateUserDtoTest extends AbstractValidationTest<CreateUserDto> {

  @Test
  public void testGivEntityEmptyName() {
    assertThat(
        givenEmptyName(new CreateUserDto("adress", "", LocalDate.of(2024, 1, 1)))).isTrue();
  }

  @Test
  public void testGivenNoBirthDate() {
    assertThat(
        givenNoBirthDate(new CreateUserDto("adress", "My name", null))).isTrue();
  }

  @Test
  public void testGivenNoAddress() {
    assertThat(
        givenNoAddress(new CreateUserDto("", "My name", LocalDate.of(2024, 1, 1))))
        .isTrue();
  }
}
