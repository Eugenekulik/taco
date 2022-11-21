package by.eugenekulik.taco.controller;

import by.eugenekulik.taco.domain.RegistrationForm;
import by.eugenekulik.taco.domain.User;
import by.eugenekulik.taco.dto.JwtUserAuthorizationDto;
import by.eugenekulik.taco.security.JwtProvider;
import by.eugenekulik.taco.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/register",produces = "application/json")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider provider;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping
    public String registerForm(){
        return "registration";
    }

    @PostMapping
    public JwtUserAuthorizationDto proccessRegistration(@RequestBody RegistrationForm registrationForm){
        User user = userService.registrate(registrationForm.toUser());
        if(user!=null) {
            String token = provider.generateToken(user.getUsername());
            return new JwtUserAuthorizationDto(token,user);
        }
        return null;
    }
}
