package com.itransition.training.task05.Users.repository;

import com.itransition.training.task05.Users.models.TableUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<TableUsers, String> {

    TableUsers findByUserName(String username);
}
