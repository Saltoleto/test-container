package br.com.saltoleto.testcontainer.controller;


import br.com.saltoleto.testcontainer.model.entity.User;
import br.com.saltoleto.testcontainer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@Profile("!test")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public Flux<User> getUsers() {
        return userRepository.findAll();
    }
}
