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


    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new User(1,"Haawdawdawddi","teacher","root",1,2));
        save(new User(5,"Not_hadi","student","root",2,3));
    }
}
