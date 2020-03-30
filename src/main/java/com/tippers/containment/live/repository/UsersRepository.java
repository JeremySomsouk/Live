package com.tippers.containment.live.repository;

import com.tippers.containment.live.repository.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UserModel, Long> {
}
