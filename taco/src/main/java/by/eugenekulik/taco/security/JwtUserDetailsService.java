package by.eugenekulik.taco.security;

import by.eugenekulik.taco.dao.JpaUserRepository;
import by.eugenekulik.taco.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private JpaUserRepository userRepo;
    @Autowired
    public JwtUserDetailsService(JpaUserRepository userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user != null) {
            return new JwtUserDetails(user);
        }
        throw new UsernameNotFoundException(
                "User '" + username + "' not found");
    }
}
