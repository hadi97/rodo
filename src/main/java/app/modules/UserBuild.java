package app.modules;

public class UserBuild {
    private String login;
    private String password_;
    private String role;
    private String first_name;
    private String last_name;

    public UserBuild(String login, String password_) {
        this.login = login;
        this.password_ = password_;
    }

    public UserBuild setRole(String role) {
        this.role = role;
        return this;
    }

    public UserBuild setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public UserBuild setLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }



    public Account createUser() {
        return new Account(first_name, last_name,login, password_, role);
    }
}
