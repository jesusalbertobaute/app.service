package app.auth.service.user.controller;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private String userName;
}
