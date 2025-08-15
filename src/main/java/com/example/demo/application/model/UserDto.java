// SPDX-FileCopyrightText: 2025 diggsweden/wallet-backend-reference
//
// SPDX-License-Identifier: EUPL-1.2

package com.example.demo.application.model;

import io.soabase.recordbuilder.core.RecordBuilder;
import java.time.LocalDate;

@RecordBuilder
public record UserDto(
    String address,
    String name,
    LocalDate birthDate) {
}
