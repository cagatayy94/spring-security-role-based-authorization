package com.example.springsecurity;

import com.example.springsecurity.entity.AppUser;
import com.example.springsecurity.entity.Role;
import com.example.springsecurity.entity.business.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner run(AppUserService userService){
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new AppUser(null, "John doe", "usr1", "123456aa",new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Mahmut Tuncer", "usr2", "123456aa",new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Demir Çelik", "usr3", "123456aa",new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Kral", "usr4", "123456aa",new ArrayList<>()));

            userService.addRoleToUser("usr1","ROLE_USER");
            userService.addRoleToUser("usr1","ROLE_MANAGER");
            userService.addRoleToUser("usr2","ROLE_MANAGER");
            userService.addRoleToUser("usr3","ROLE_ADMIN");
            userService.addRoleToUser("usr4","ROLE_SUPER_ADMIN");
            userService.addRoleToUser("usr4","ROLE_ADMIN");
            userService.addRoleToUser("usr4","ROLE_USER");
        };
    }

}
