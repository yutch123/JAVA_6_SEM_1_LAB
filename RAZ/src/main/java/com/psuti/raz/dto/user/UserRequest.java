package com.psuti.raz.dto.user;

import com.psuti.raz.dto.role.RoleRequest;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class UserRequest {
    private UUID id;
    private String firstName;
    private String lastName;
    private RoleRequest role;
}
