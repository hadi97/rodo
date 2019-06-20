package app.service;

import app.Interfaces.UserRepository;
import app.modules.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserManager {
    private final UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //get
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }


    //get all users
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }


    //adding user
    public User save(User user) {
        return userRepository.save(user);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new User(4,"Charlie","teacher","root",1));
        save(new User(3,"Jake","student","root",2));
    }
}
