package by.eugenekulik.taco.services;

import by.eugenekulik.taco.domain.User;

public interface UserService {


    User registrate(User user);
    User authorize(User user);
}
