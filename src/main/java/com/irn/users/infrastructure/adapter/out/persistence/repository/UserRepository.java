package com.irn.users.infrastructure.adapter.out.persistence.repository;

import com.irn.users.infrastructure.adapter.out.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
