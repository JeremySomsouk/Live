package com.tippers.containment.live.repository;

import com.tippers.containment.live.repository.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepository extends JpaRepository<UserModel, Long> {
    @Query("select user from #{#entityName} user where user.username = ?1")
    UserModel getByUsername(String username);
}
