// SPDX-FileCopyrightText: 2025 diggsweden/wallet-backend-reference
//
// SPDX-License-Identifier: EUPL-1.2

package com.example.demo.domain.service;

import com.example.demo.application.model.CreateUserDto;
import com.example.demo.application.model.UserDto;
import com.example.demo.application.model.UserDtoBuilder;
import com.example.demo.domain.model.User;
import com.example.demo.domain.model.UserBuilder;
import com.example.demo.infrastructure.model.UserEntity;

public class UserMapper {
  private UserMapper() {}

  public static User toDomain(UserEntity user) {
    return UserBuilder.builder()
        .id(user.getId())
        .address(user.getAddress())
        .name(user.getName())
        .birthDate(user.getBirthDate())
        .build();
  }

  public static UserEntity toUserEntity(User user) {
    UserEntity userEntity = new UserEntity();
    userEntity.setId(user.id());
    userEntity.setName(user.name());
    userEntity.setAddress(user.address());
    userEntity.setBirthDate(user.birthDate());
    return userEntity;
  }

  public static User toUser(UserDto userDto) {
    return UserBuilder.builder()
        .address(userDto.address())
        .name(userDto.name())
        .birthDate(userDto.birthDate())
        .build();
  }

  public static User toUser(CreateUserDto createUserDto) {
    return toUser(toUserDto(createUserDto));
  }

  public static UserDto toUserDto(UserEntity userEntity) {
    return toUserDto(toDomain(userEntity));
  }

  public static UserDto toUserDto(CreateUserDto user) {
    return new UserDto(user.address(), user.name(), user.birthDate());
  }

  public static UserDto toUserDto(User user) {
    return UserDtoBuilder.builder()
        .address(user.address())
        .name(user.name())
        .birthDate(user.birthDate())
        .build();
  }
}

