// SPDX-FileCopyrightText: 2025 diggsweden/wallet-backend-reference
//
// SPDX-License-Identifier: EUPL-1.2
package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.Set;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

/**
 * As object created in front and database layer are similar we assert booth in similar way
 */
public abstract class AbstractValidationTest<T> {
  Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public Boolean givenEmptyName(T testObject) {
    Set<ConstraintViolation<T>> violations = validator.validate(testObject);
    assertField(violations, "name", 0);
    return true;
  }

  public Boolean assertField(Set<ConstraintViolation<T>> violations, String fieldName,
      int index) {
    assertThat(violations).hasSize(1);
    assertThat(new ArrayList<ConstraintViolation<T>>(violations).get(index)
        .getPropertyPath().toString()).hasToString(fieldName);
    return true;
  }

  public Boolean givenNoBirthDate(T testObject) {
    Set<ConstraintViolation<T>> violations = validator.validate(testObject);
    assertField(violations, "birthDate", 0);
    return true;
  }

  public Boolean givenNoAddress(T testObject) {
    Set<ConstraintViolation<T>> violations = validator.validate(testObject);
    assertField(violations, "address", 0);
    return true;
  }

}
