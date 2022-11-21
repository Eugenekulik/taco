package by.eugenekulik.taco.dto;

import by.eugenekulik.taco.domain.Role;
import by.eugenekulik.taco.domain.User;
import lombok.Data;

import java.util.Set;

@Data
public class JwtUserAuthorizationDto {
    private String token;
    private String fullname;
    private Set<Role> roles;

    public JwtUserAuthorizationDto(String token, User user) {
        this.token = token;
        this.fullname = user.getFullname();
        this.roles = user.getRoles();
    }
}
