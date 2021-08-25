package app.service;

import app.Interfaces.UserRepository;
import app.modules.Account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserManager {
    private final UserRepository userRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserManager.class);

    @Autowired
    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //get
    public Optional<Account> findById(int id) {
        return userRepository.findById(id);
    }


    //get all users
    /*
    public Iterable<Student> findAll() {
        return St.findAll();
    }*/

    public Account save(Account account){
        return userRepository.save(account);
    }
    public Account getAccountByUsernameOrThrow(String username){
            Optional<Account> maybeAccount = userRepository.findAll()
                    .stream()
                    .filter(account -> account.getUsername().equals(username))
                    .findAny();
            if (maybeAccount.isPresent()) {
                return maybeAccount.get();
            } else {
                LOGGER.warn("Could not find account by username {}", username);
                return null;
            }
    }
public String getName(Integer userId){
        return userRepository.findById(userId).get().getFirstName()+" "+userRepository.findById(userId).get().getLastName();
}
    //adding student

/*
    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new Student(1,"Charlie","TEACHER","root",1));
        save(new Student(2,"Marlie","TEACHER","root",2));

        save(new Student(211111,"Armin","STUDENT","root",1));
        save(new Student(209999,"Mikasa","STUDENT","root",1));
        save(new Student(212322,"Eren","STUDENT","root",2));
        save(new Student(223121,"Levi","STUDENT","root",2));
        save(new Student(212151,"Zero","STUDENT","root",2));
        save(new Student(201231,"Hero","STUDENT","root",2));
        save(new Student(192312,"Mac","STUDENT","root",1));
        save(new Student(192312,"Jack","STUDENT","root",1));

    }*/

}
