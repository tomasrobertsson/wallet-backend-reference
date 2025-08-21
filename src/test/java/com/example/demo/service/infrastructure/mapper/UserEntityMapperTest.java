// SPDX-FileCopyrightText: 2025 diggsweden/wallet-backend-reference
//
// SPDX-License-Identifier: EUPL-1.2

package com.example.demo.service.infrastructure.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.example.demo.domain.model.User;
import com.example.demo.domain.model.UserBuilder;
import com.example.demo.infrastructure.mapper.UserEntityMapper;


class UserEntityMapperTest {
  @Test
  void verifyFromDomainAndBack() {
    User defaultUser = UserBuilder.builder()
        .address("Street")
        .name("Dummy")
        .birthDate(LocalDate.of(2024, 1, 1))
        .id(UUID.randomUUID())
        .build();
    assertThat(UserEntityMapper.toDomain(UserEntityMapper.toEntity(defaultUser)))
        .isEqualTo(defaultUser);
  }
}
