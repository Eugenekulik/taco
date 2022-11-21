package by.eugenekulik.taco.controller;


import by.eugenekulik.taco.domain.User;
import by.eugenekulik.taco.dto.TokenRequest;
import by.eugenekulik.taco.dto.JwtUserAuthorizationDto;
import by.eugenekulik.taco.security.JwtProvider;
import by.eugenekulik.taco.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/auth", produces = "application/json")
public class AuthenticateController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider provider;

    @PostMapping
    public @ResponseBody
    JwtUserAuthorizationDto authenticate(@RequestBody TokenRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        if((user = userService.authorize(user))!=null) {
            String token = provider.generateToken(user.getUsername());
            return new JwtUserAuthorizationDto(token, user);
        }
        return null;
    }
}
