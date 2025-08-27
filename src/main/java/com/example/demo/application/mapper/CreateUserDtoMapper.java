// SPDX-FileCopyrightText: 2025 diggsweden/wallet-backend-reference
//
// SPDX-License-Identifier: EUPL-1.2

package com.example.demo.application.mapper;

import com.example.demo.application.model.CreateUserDto;
import com.example.demo.domain.model.User;
import com.example.demo.domain.model.UserBuilder;

public final class CreateUserDtoMapper {

  private CreateUserDtoMapper() {}

  public static User toDomain(CreateUserDto dto) {
    return UserBuilder.builder()
        .address(dto.address())
        .name(dto.name())
        .birthDate(dto.birthDate())
        .build();
  }
}
