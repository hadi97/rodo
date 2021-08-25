package app.controllers;
import app.Interfaces.StudentRepository;
import app.Interfaces.TeacherRepo;
import app.Security.LoginForm;
import app.Security.ResponseMessage;
import app.Security.SignUpForm;
import app.Security.jwt.JwtProvider;
import app.Security.jwt.JwtResponse;
import app.modules.Account;
import app.modules.Student;
import app.modules.Teacher;
import app.modules.UserBuild;
import app.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("auth")
public class UserApi {


    private final UserManager accountManager;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder encoder;

    private final StudentRepository studentRepository;

    private final JwtProvider jwtProvider;
    private final TeacherRepo teacherRepo;

    @Autowired
    public UserApi(UserManager accountManager, TeacherRepo teacherRepo,AuthenticationManager authenticationManager, PasswordEncoder encoder, JwtProvider jwtProvider,StudentRepository studentRepository) {
        this.accountManager = accountManager;
        this.authenticationManager = authenticationManager;
        this.encoder = encoder;
        this.jwtProvider = jwtProvider;
        this.studentRepository = studentRepository;
        this.teacherRepo = teacherRepo;
    }




    @PostMapping(value = "login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest)  {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        int userId = accountManager.getAccountByUsernameOrThrow(loginRequest.getUsername()).getAccountId();
        //debugging some things
        System.out.println(userId);
        System.out.println(jwt);
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userId, userDetails.getAuthorities()));
    }

    @Transactional
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity<?> registerAccount(@RequestBody SignUpForm signUpRequest) {
        if (accountManager.getAccountByUsernameOrThrow(signUpRequest.getUsername()) != null) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Login/Email is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        Account user = new UserBuild(signUpRequest.getUsername(), encoder.encode(signUpRequest.getPassword()))
                .setFirst_name(signUpRequest.getFirstName())
                .setLast_name(signUpRequest.getLastName())
                .setRole("teacher")
                .createUser();


        accountManager.save(user);

        Account user1 = accountManager.getAccountByUsernameOrThrow(signUpRequest.getUsername());
        // Creating user's account
        System.out.println("user id : "+user1.getAccountId());

        teacherRepo.save(new Teacher(user1.getAccountId()));

        return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);

    }


    @GetMapping(produces = "application/json")
    @RequestMapping({ "/validateLogin" })
    public Student validateLogin() {
        return new Student();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/get")
    public Optional<Account> getById(@RequestParam Integer id) {
        return accountManager.findById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
      //  registerAccount(new SignUpForm("teacher", "password","Jan","Kowalski","teacher",null));
        /*
        registerAccount(new SignUpForm("student1", "password","Aleksander","Brzeziński","student",211111));
        registerAccount(new SignUpForm("student2", "password","Oliwia","Nowicka","student",211112));
        registerAccount(new SignUpForm("student3", "password","Aleksy","Jasiński","student",211113));
        registerAccount(new SignUpForm("student4", "password","Michał","Kwiatkowski","student",211114));
        registerAccount(new SignUpForm("student5", "password","Zofia","Leszczyńska","student",211115));
        registerAccount(new SignUpForm("student6", "password","Wiktoria","Brzezińska","student",211116));
    */
    }

    /*
    @RequestMapping(method = RequestMethod.POST)
    public Student addUser(@RequestBody Student student) {
        return userManager.save(student);
    }

*/
}
