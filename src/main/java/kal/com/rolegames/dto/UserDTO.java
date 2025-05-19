package kal.com.rolegames.dto;

import kal.com.rolegames.models.users.User;
import kal.com.rolegames.models.util.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Long userId;
    private String username;
    private String email;
    private UserType userType;
    private LocalDateTime createdAt;

    public UserDTO(User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.userType = user.getUserType();
        this.createdAt = user.getCreatedAt();
    }
}