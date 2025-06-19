package com.example.demo.service.infrastructure;

import static org.assertj.core.api.Assertions.*;
import java.time.LocalDate;
import java.util.UUID;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.System;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.infrastructure.model.UserEntity;
import com.example.demo.infrastructure.repository.UserRepository;

import jakarta.transaction.Transactional;



@DataJpaTest
@ActiveProfiles("h2") 
@TestInstance(Lifecycle.PER_CLASS)
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;
    private UUID userId;
    @BeforeAll
    @Transactional
    void prepareTest() {
        UserEntity user =  new UserEntity();
        user.setAddress("Street 1");
        user.setName("Dummy");
        user.setBirthDate(LocalDate.of(2024, 01, 01));
        userRepository.save(user);
        userId = user.getId();
    }

    @Test
    void testUserRepo() {
        Optional<UserEntity> user =  userRepository.findById(userId);
        assertThat(user).isPresent();
        assertThat(user.get().getAddress()).isEqualTo("Street 1");
    }
}