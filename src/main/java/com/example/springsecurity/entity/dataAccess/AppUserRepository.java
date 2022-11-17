package com.example.springsecurity.entity.dataAccess;

import com.example.springsecurity.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser getAppUserByUsername(String name);
}
