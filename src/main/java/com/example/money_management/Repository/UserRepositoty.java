package com.example.money_management.Repository;

import com.example.money_management.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoty extends JpaRepository<User, Long> {
}
