package com.example.springsecurity.entity.business;

import com.example.springsecurity.entity.AppUser;
import com.example.springsecurity.entity.Role;

import java.util.List;

public interface AppUserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();

}
