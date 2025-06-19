package com.example.demo.application.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.application.model.CreateUserDto;
import com.example.demo.application.model.UserDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/users")
public class UserController {

    @GetMapping("{id}")
    public UserDto getUser(@PathVariable String id) {
        return null;
    }

    // TODO well defined openapi docs
    // IF TOO CLUTTERY MOVE TO INTERFACE?
    @Operation(responses = {
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "4xx"),
            @ApiResponse(responseCode = "5xx"),
    })
    @PostMapping
    public ResponseEntity<UserDto> addUser(CreateUserDto user) {
        return ResponseEntity.created(URI.create("/users/" + "id")).build(); // ?
    }
}
