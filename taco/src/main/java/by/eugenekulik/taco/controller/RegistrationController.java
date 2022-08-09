package by.eugenekulik.taco.controller;

import by.eugenekulik.taco.dao.JPAImpl.JpaUserRepository;
import by.eugenekulik.taco.domain.RegistrationForm;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private JpaUserRepository userRepository;
    private PasswordEncoder encoder;

    public RegistrationController(JpaUserRepository userRepository, PasswordEncoder encoder){
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String registerForm(){
        return "registration";
    }

    @PostMapping
    public String proccessRegistration(RegistrationForm registrationForm){
        userRepository.save(registrationForm.toUser(encoder));
        return "redirect:/login";
    }
}
