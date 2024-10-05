package kg.attractor.onlinelibrary.dto;

import kg.attractor.onlinelibrary.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserProfileDto {
    private User user;
    private boolean isAdmin;
}
