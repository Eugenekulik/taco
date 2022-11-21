package by.eugenekulik.taco.services;

import by.eugenekulik.taco.dao.JpaUserRepository;
import by.eugenekulik.taco.domain.Role;
import by.eugenekulik.taco.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
public class UserServiceSimpleImpl implements UserService {
    @Autowired
    private JpaUserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public User registrate(@Valid User user) {
        try {
            user.setPassword(encoder.encode(user.getPassword()));
            Set<Role> roles = new HashSet<>();
            roles.add(new Role(2, "USER"));
            user.setRoles(roles);
            user = userRepository.save(user);
            return user;
        } catch (DataAccessException e){
            log.error("can't save user with name: " + user.getUsername());
        }
        return null;
    }

    @Override
    public User authorize(User user) {
        User current = userRepository.findByUsername(user.getUsername());
        if(current != null){
            if(encoder.matches(user.getPassword(),current.getPassword())) {
                return current;
            }
            else throw new CredentialsExpiredException("bad password");
        }
        throw new UsernameNotFoundException("user with name " + user.getUsername() + " not found");
    }


}
