package com.psuti.raz.dto.user;

import com.psuti.raz.dto.role.RoleResponse;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class UserResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private RoleResponse role;
}
