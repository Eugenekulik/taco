package by.eugenekulik.taco.dao.JPAImpl;

import by.eugenekulik.taco.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface JpaUserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
