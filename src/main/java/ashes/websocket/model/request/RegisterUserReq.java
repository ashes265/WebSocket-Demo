package ashes.websocket.model.request;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class RegisterUserReq {
    @NotBlank(message = "username is required")
    String username;
    @NotBlank(message = "password is required")
    String password;
    String email;
    String phone;
    Integer age;
}
