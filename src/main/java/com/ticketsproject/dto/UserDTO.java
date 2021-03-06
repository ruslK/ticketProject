package com.ticketsproject.dto;

import com.ticketsproject.enums.Gender;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private boolean enabled;
    private String phone;
    private RoleDTO role;
    private Gender gender;
}
