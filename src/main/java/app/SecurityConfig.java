package app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails student = User.withDefaultPasswordEncoder()
                .username("student")
                .password("studentPass")
                .roles("STUDENT")
                .build();
        UserDetails teacher = User.withDefaultPasswordEncoder()
                .username("teacher")
                .password("teacherPass")
                .roles("TEACHER")
                .build();
        return new InMemoryUserDetailsManager(student,teacher);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                //.antMatchers(HttpMethod.GET, "/api/marks/getAll").hasRole("TEACHER")
               // .antMatchers(HttpMethod.GET,"/api/employees/get").hasRole("TEACHER")

                .antMatchers(HttpMethod.POST, "/api/marks").hasAnyRole("TEACHER")
                .antMatchers(HttpMethod.POST, "/api/subjects").hasRole("TEACHER")
                .antMatchers(HttpMethod.POST,"/api/users").hasRole("TEACHER")
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable();
    }

}
