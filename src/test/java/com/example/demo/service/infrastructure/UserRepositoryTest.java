// SPDX-FileCopyrightText: 2025 diggsweden/wallet-backend-reference
//
// SPDX-License-Identifier: EUPL-1.2

package com.example.demo.service.infrastructure;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.UUID;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.example.demo.TestcontainersConfiguration;
import com.example.demo.infrastructure.model.UserEntity;
import com.example.demo.infrastructure.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.FlushModeType;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@DataJpaTest
@TestInstance(Lifecycle.PER_CLASS)
@Import(TestcontainersConfiguration.class)
class UserRepositoryTest {
  @PersistenceContext
  EntityManager entityManager;

  @Autowired
  UserRepository userRepository;
  private UUID userId;

  @BeforeAll
  @Transactional
  void prepareTest() {
    UserEntity user = new UserEntity();
    user.setAddress("Street 1");
    user.setName("Dummy");
    user.setBirthDate(LocalDate.of(2024, 01, 01));
    userRepository.save(user);
    userId = user.getId();
  }

  @Test
  void testUserRepo() {
    Optional<UserEntity> user = userRepository.findById(userId);
    assertThat(user).isPresent();
    assertThat(user.get().getAddress()).isEqualTo("Street 1");
  }

  @Test
  void testSaveEmtpyName() {
    entityManager.setFlushMode(FlushModeType.COMMIT);
    UserEntity user = new UserEntity();
    user.setAddress("S1333");
    user.setBirthDate(LocalDate.of(2024, 01, 01));
    UUID userID = userRepository.save(user).getId();

    assertThrows(jakarta.validation.ConstraintViolationException.class,
        () -> entityManager.flush());
    entityManager.clear();
    UserEntity user2 = entityManager.find(UserEntity.class, userID);
    assertThat(user2).isNull();
  }


}
