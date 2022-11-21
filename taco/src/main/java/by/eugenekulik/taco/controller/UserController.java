package by.eugenekulik.taco.controller;


import by.eugenekulik.taco.dao.JpaUserRepository;
import by.eugenekulik.taco.domain.Taco;
import by.eugenekulik.taco.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {
    @Autowired
    private JpaUserRepository repository;


    @GetMapping
    public @ResponseBody
    Iterable<User> getAllUsers(){
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable long id){
        repository.deleteById(id);
        return new ResponseEntity<Long>(id, HttpStatus.OK);
    }
}
