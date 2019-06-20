package app.controllers;
import app.modules.User;
import app.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/users")
public class UserApi {
    private UserManager userManager;

    @Autowired
    public UserApi(UserManager userManager) {
        this.userManager = userManager;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getAll")
    public Iterable<User> getAll() {
        return userManager.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/get")
    public Optional<User> getById(@RequestParam Long id) {
        return userManager.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        return userManager.save(user);
    }
}
