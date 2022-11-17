package com.example.springsecurity.entity.api;

import com.example.springsecurity.entity.AppUser;
import com.example.springsecurity.entity.Role;
import com.example.springsecurity.entity.business.AppUserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AppUserController {
    private AppUserService userService;

    @Autowired
    public AppUserController(AppUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public ResponseEntity<List<AppUser>> getAllUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping("/user")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addToUser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        userService.addRoleToUser(form.username, form.rolename);
        return ResponseEntity.ok().build();
    }

    @Data
    static
    class RoleToUserForm {
        private String username;
        private String rolename;
    }
}
