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
        save(new User(1,"Charlie","TEACHER","root",1));
        save(new User(2,"Marlie","TEACHER","root",2));

        save(new User(211111,"Armin","STUDENT","root",1));
        save(new User(209999,"Mikasa","STUDENT","root",1));
        save(new User(212322,"Eren","STUDENT","root",2));
        save(new User(223121,"Levi","STUDENT","root",2));
        save(new User(212151,"Zero","STUDENT","root",2));
        save(new User(201231,"Hero","STUDENT","root",2));
        save(new User(192312,"Mac","STUDENT","root",1));
        save(new User(192312,"Jack","STUDENT","root",1));

    }
}
