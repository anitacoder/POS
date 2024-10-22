package org.example.pos.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminRequest {
    private String fullName;
    private String email;
    private String Admin_Phone;
    private String username;
    private String password;

}
