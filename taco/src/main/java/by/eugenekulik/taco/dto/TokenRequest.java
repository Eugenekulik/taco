package by.eugenekulik.taco.dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TokenRequest {
    private String username;
    private String password;
}
