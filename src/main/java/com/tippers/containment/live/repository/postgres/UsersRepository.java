package com.tippers.containment.live.repository.postgres;

import com.tippers.containment.live.repository.model.postgres.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query("select user from #{#entityName} user where user.username = ?1")
    Users getByUsername(String username);
}
