package com.psuti.raz.service;

import com.psuti.raz.dto.user.UserRequest;
import com.psuti.raz.dto.user.UserResponse;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserResponse> findAll();
    @NotNull
    UserResponse findById(@NotNull UUID userId);
    @NotNull
    UserResponse createUser(@NotNull UserRequest request);
    @NotNull
    UserResponse update(@NotNull UUID userId,@NotNull UserRequest request);

    void delete(@NotNull UUID userId);
}
