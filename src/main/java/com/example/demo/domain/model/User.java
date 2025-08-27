// SPDX-FileCopyrightText: 2025 diggsweden/wallet-backend-reference
//
// SPDX-License-Identifier: EUPL-1.2

package com.example.demo.domain.model;

import io.soabase.recordbuilder.core.RecordBuilder;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Immutable record for User data. Recommend use of builder pattern, i.e. UserBuilder.builder()
 */
@RecordBuilder()
public record User(
    UUID id,
    String address,
    String name,
    LocalDate birthDate) {

}
