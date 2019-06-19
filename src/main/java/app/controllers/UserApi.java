package app.controllers;
import app.modules.User;
import app.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserApi {
    private UserManager userManager;

    @Autowired
    public UserApi(UserManager userManager) {
        this.userManager = userManager;
    }

    @CrossOrigin
    @GetMapping("/all")
    public Iterable<User> getAll() {
        return userManager.findAll();
    }

    @CrossOrigin
    @GetMapping
    public Optional<User> getById(@RequestParam Long id) {
        return userManager.findById(id);
    }

    @CrossOrigin
    @PostMapping
    public User addUser(@RequestBody User user) {
        return userManager.save(user);
    }
}
